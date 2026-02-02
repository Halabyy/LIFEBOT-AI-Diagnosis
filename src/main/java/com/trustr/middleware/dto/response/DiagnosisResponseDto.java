package com.trustr.middleware.dto.response;

// NOTE: Not currently used. Reserved for future Trustr JSON responses.

public class DiagnosisResponseDto {

    private String diagnosis;
    private double riskScore;
    private String recommendation;

    // Constructors
    public DiagnosisResponseDto() {}

    public DiagnosisResponseDto(String diagnosis, double riskScore, String recommendation) {
        this.diagnosis = diagnosis;
        this.riskScore = riskScore;
        this.recommendation = recommendation;
    }

    // Getters & Setters
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
