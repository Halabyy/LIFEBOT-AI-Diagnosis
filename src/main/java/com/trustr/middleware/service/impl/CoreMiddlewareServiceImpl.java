package com.trustr.middleware.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.trustr.middleware.dto.request.SymptomRequestDto;
import com.trustr.middleware.exception.LifeBotException;
import com.trustr.middleware.exception.TrustrException;
import com.trustr.middleware.exception.UIDataException;
import com.trustr.middleware.service.CoreMiddlewareService;
import com.trustr.trustr.ChatGptDiagnosisService;

@Service
public class CoreMiddlewareServiceImpl implements CoreMiddlewareService {

    private static final Logger logger = LoggerFactory.getLogger(CoreMiddlewareServiceImpl.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private final ChatGptDiagnosisService chatGptDiagnosisService;

    public CoreMiddlewareServiceImpl(ChatGptDiagnosisService chatGptDiagnosisService) {
        this.chatGptDiagnosisService = chatGptDiagnosisService;
    }

    // Refactored: Use only SymptomRequestDto for full diagnosis (includes vitals)
    @Override
    public String fullDiagnosisFromUI(SymptomRequestDto requestDto) {
        if (requestDto == null || requestDto.getSymptoms() == null || requestDto.getAge() == null || requestDto.getGender() == null) {
            logger.error("❌ UI input missing required fields.");
            throw new UIDataException("Missing required UI fields: symptoms, age, or gender.");
        }

        // Validate required vitals
        if (requestDto.getBloodPressure() == null || requestDto.getSpo2() == null) {
            logger.error("❌ Vitals missing: bloodPressure or spo2.");
            throw new LifeBotException("Required vitals missing: bloodPressure or spo2.");
        }

        // Log received vitals for verification
        logger.info("Received diagnosis request: bloodPressure={}, spo2={}, etco2={}, peripheralPulse={}, respirationRate={}",
            requestDto.getBloodPressure(),
            requestDto.getSpo2(),
            requestDto.getEtco2(),
            requestDto.getPeripheralPulse(),
            requestDto.getRespirationRate()
        );

        StringBuilder sb = new StringBuilder();
        sb.append("Symptoms: ").append(requestDto.getSymptoms()).append(", ");
        sb.append("Age: ").append(requestDto.getAge()).append(", ");
        sb.append("Gender: ").append(requestDto.getGender()).append(", ");
        sb.append("Allergies: ").append(requestDto.getAllergies()).append(", ");
        sb.append("Medical Conditions: ").append(requestDto.getMedicalConditions()).append(", ");
        sb.append("Smoke: ").append(requestDto.getSmoke()).append(", ");
        sb.append("Activity: ").append(requestDto.getActivity()).append(", ");
        sb.append("Alcohol: ").append(requestDto.getAlcohol()).append(", ");
        sb.append("Medication: ").append(requestDto.getMedication()).append(", ");
        sb.append("Medication List: ").append(requestDto.getMedicationList()).append(", ");
        sb.append("Allergy Label: ").append(requestDto.getAllergyLabel()).append(", ");
        sb.append("Blood Pressure: ").append(requestDto.getBloodPressure()).append(", ");
        sb.append("SpO2: ").append(requestDto.getSpo2()).append(", ");
        sb.append("EtCO2: ").append(requestDto.getEtco2()).append(", ");
        sb.append("Peripheral Pulse: ").append(requestDto.getPeripheralPulse()).append(", ");
        sb.append("Respiration Rate: ").append(requestDto.getRespirationRate());

        String mergedString = sb.toString();
        return chatGptDiagnosisService.getDiagnosisFromAI(mergedString);
    }

    // If you still need to send to Trustr, use the unified DTO
    @Override
    public String sendToTrustr(SymptomRequestDto requestDto) {
        if (requestDto == null) {
            logger.error("❌ SymptomRequestDto is null.");
            throw new TrustrException("Cannot process null diagnosis data.");
        }

        String trustrUrl = "https://gradproject-production-e611.up.railway.app/mock-trustr/analyze";

        try {
            logger.info("📡 Sending unified DTO to Trustr at [{}]...", trustrUrl);
            String response = restTemplate.postForObject(trustrUrl, requestDto.toString(), String.class);
            logger.info("📥 Diagnosis received from Trustr: {}", response);
            return response;
        } catch (RestClientException e) {
            logger.error("❌ Failed to communicate with Trustr API: {}", e.getMessage());
            throw new TrustrException("Trustr API communication error: " + e.getMessage());
        }
    }

    // Helper methods for safe parsing (if needed elsewhere)
    private Integer parseIntSafe(String value) {
        try {
            return value == null || value.isEmpty() ? null : Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
    private Float parseFloatSafe(String value) {
        try {
            return value == null || value.isEmpty() ? null : Float.parseFloat(value);
        } catch (Exception e) {
            return null;
        }
    }
}
