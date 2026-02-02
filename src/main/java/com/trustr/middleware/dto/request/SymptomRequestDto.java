package com.trustr.middleware.dto.request;

import java.util.List;

public class SymptomRequestDto {

    private String symptoms;
    private String age;
    private String gender;
    private List<String> medicalConditions;
    private String smoke;
    private String activity;
    private String alcohol;
    private String medication;
    private String medicationList;
    private List<String> allergies;
    private String allergyLabel;
    private String bloodPressure;
    private String spo2;
    private String etco2;
    private String peripheralPulse;
    private String respirationRate;

    public SymptomRequestDto() {}

    public SymptomRequestDto(
        String symptoms,
        String age,
        String gender,
        List<String> medicalConditions,
        String smoke,
        String activity,
        String alcohol,
        String medication,
        String medicationList,
        List<String> allergies,
        String allergyLabel,
        String bloodPressure,
        String spo2,
        String etco2,
        String peripheralPulse,
        String respirationRate
    ) {
        this.symptoms = symptoms;
        this.age = age;
        this.gender = gender;
        this.medicalConditions = medicalConditions;
        this.smoke = smoke;
        this.activity = activity;
        this.alcohol = alcohol;
        this.medication = medication;
        this.medicationList = medicationList;
        this.allergies = allergies;
        this.allergyLabel = allergyLabel;
        this.bloodPressure = bloodPressure;
        this.spo2 = spo2;
        this.etco2 = etco2;
        this.peripheralPulse = peripheralPulse;
        this.respirationRate = respirationRate;
    }

    // Getters & Setters
    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(List<String> medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(String medicationList) {
        this.medicationList = medicationList;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getAllergyLabel() {
        return allergyLabel;
    }

    public void setAllergyLabel(String allergyLabel) {
        this.allergyLabel = allergyLabel;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getSpo2() {
        return spo2;
    }

    public void setSpo2(String spo2) {
        this.spo2 = spo2;
    }

    public String getEtco2() {
        return etco2;
    }

    public void setEtco2(String etco2) {
        this.etco2 = etco2;
    }

    public String getPeripheralPulse() {
        return peripheralPulse;
    }

    public void setPeripheralPulse(String peripheralPulse) {
        this.peripheralPulse = peripheralPulse;
    }

    public String getRespirationRate() {
        return respirationRate;
    }

    public void setRespirationRate(String respirationRate) {
        this.respirationRate = respirationRate;
    }
}
