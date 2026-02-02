package com.trustr.trustr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatGptDiagnosisService {

    @Value("${trustr.api.url:https://aibackend-production-7e30.up.railway.app/analyze}")
    private String trustrApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getDiagnosisFromAI(String symptoms) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap<>();
        body.put("symptoms", symptoms);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(trustrApiUrl, request, Map.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Object analysis = response.getBody().get("analysis");
                return analysis != null ? analysis.toString() : "No analysis returned.";
            } else {
                return "AI service error: Unexpected response.";
            }
        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            return "AI service error: " + ex.getResponseBodyAsString();
        } catch (Exception ex) {
            return "AI service error: " + ex.getMessage();
        }
    }
}
