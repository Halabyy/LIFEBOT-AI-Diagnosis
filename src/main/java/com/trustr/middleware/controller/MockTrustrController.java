package com.trustr.middleware.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mock-trustr")
public class MockTrustrController {

    @PostMapping("/analyze")
    public String analyzePatientData(@RequestBody String mergedData) {
        // Simulate a diagnosis string response
        return "Diagnosis: Possible viral infection. Recommendation: Rest and hydrate.";
    }
}
