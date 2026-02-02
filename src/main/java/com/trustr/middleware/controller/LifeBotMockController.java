// package com.trustr.middleware.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.trustr.middleware.dto.request.LifeBotSensorDataDTO;

// @RestController
// public class LifeBotMockController {

//     // This endpoint now fetches real (emulated) sensor data from the Node.js receiver
//     @GetMapping("/lifebot/sensors")
//     public LifeBotSensorDataDTO getRealSensorData() {
//         // Return static/mock data for testing/demo
//         return new LifeBotSensorDataDTO(
//             "120/80 (80)", // bloodPressure
//             98,            // spo2 as Integer
//             40.0f,         // etco2 as Float
//             75,            // peripheralPulse as Integer
//             16             // respirationRate as Integer
//         );
//     }

//     // Optional: Keep this if you want to test receiving sensor data (not needed for middleware)
//     @PostMapping("/lifebot/sensors")
//     public String receiveSensorData(@RequestBody LifeBotSensorDataDTO sensorData) {
//         return "Sensor data received successfully!";
//     }
// }
