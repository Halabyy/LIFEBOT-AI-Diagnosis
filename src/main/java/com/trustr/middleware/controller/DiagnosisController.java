package com.trustr.middleware.controller;

import org.springframework.web.bind.annotation.*;

import com.trustr.middleware.dto.request.SymptomRequestDto;
import com.trustr.middleware.service.CoreMiddlewareService;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

    private final CoreMiddlewareService coreMiddlewareService;

    public DiagnosisController(CoreMiddlewareService coreMiddlewareService) {
        this.coreMiddlewareService = coreMiddlewareService;
    }

    /**
     * Full flow: UI sends symptoms → middleware fetches LifeBot data → merges → sends to Trustr
     */
    @PostMapping("/submit")
    public String receiveUserInput(@RequestBody SymptomRequestDto requestDto) {
        return coreMiddlewareService.fullDiagnosisFromUI(requestDto);
    }
}
