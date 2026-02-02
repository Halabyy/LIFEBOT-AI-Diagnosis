package com.trustr.middleware.service;

import com.trustr.middleware.dto.request.SymptomRequestDto;

public interface CoreMiddlewareService {
    // Unified DTO for all diagnosis operations
    String sendToTrustr(SymptomRequestDto requestDto);
    String fullDiagnosisFromUI(SymptomRequestDto requestDto);
}
