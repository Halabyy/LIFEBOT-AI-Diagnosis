# Backend Production Project Documentation

## Overview
This project aimed to deliver a fully functional, modular health middleware solution integrated directly onto an existing telemedicine device (Lifebot Health). Our goals were to collect, process, and analyze real-time vital signs and symptoms from a custom-built, user-friendly UI running on the Lifebot device, and to provide instant, AI-powered diagnosis through a robust backend and cloud deployment. Unlike traditional telemedicine systems, which are often designed for paramedics and can be complex to use, our project focused on building an accessible, intuitive UI/UX for broader user adoption. The 
middleware, built with Spring Boot, connects the Lifebot’s live sensor data and UI to a Node.js AI diagnosis service (using OpenAI), both deployed on Railway for scalability and reliability. The result is a production-ready, cloud-based platform that demonstrates technical innovation, seamless integration, and real-world healthcare impact.

---

## Architecture Diagram

```
[UI/Emulator] <--> [Spring Boot Middleware] <--> [Live LifeBot Sensor Data]
                                 \
                                  +--> [Trustr AI (Node.js/OpenAI)]
```

---

## Setup & Running

### Prerequisites
- Java 17+
- Node.js 16+
- Maven
- OpenAI API key (for Trustr AI)
- Railway account (for cloud deployment)

### 1. Clone the Repository
```powershell
git clone <your-repo-url>
cd backend-production
```

### 2. Start the Trustr AI Service (locally or deploy to Railway)
```powershell
cd trustr-ai-node
npm install
node Test3.js
```

### 3. Start the Spring Boot Middleware (locally or deploy to Railway)
```powershell
cd ..
mvn spring-boot:run
```

---

## API Endpoints

### Middleware (Spring Boot)
- `POST /diagnosis/submit`  
  Receives a unified DTO with all user symptoms and live vitals from the UI/emulator, returns diagnosis string from ChatGPT AI.

### ChatGPT AI (Node.js)
- `POST /analyze`  
  Receives symptoms string, returns AI-powered diagnosis, medication, and risk score.

---

## Data Flow
1. **UI/Emulator** collects user symptoms and live vital signs, then sends all data in a single request to the backend.
2. **Middleware** validates and logs the unified DTO, then sends a summary string to ChatGPT AI.
3. **ChatGPT AI** analyzes the data using OpenAI and returns a diagnosis.
4. **Middleware** returns the diagnosis to the UI.

---

## Configuration
- All sensitive data (API keys, URLs) are stored in environment files (`API_Key.env` for Node.js, `application.properties` for Java).
- Endpoints and ports are configurable.
- Railway deployment uses environment variables for secrets.

---

## Security
- Helmet, rate limiting, and input validation in Node.js.
- CSRF disabled for development in Spring Boot (enable for production).
- API keys are never committed to version control.

---

## Logging & Monitoring
- Winston logger in Node.js (JSON logs with timestamps).
- Logback in Spring Boot (logs to `logs/` folder and Railway logs).
- Middleware logs all received vitals for diagnosis requests.

---

## Testing
- Use Postman or the UI to test `/diagnosis/submit` and `/analyze` endpoints.
- Example request body for `/diagnosis/submit`:
```json
{
  "symptoms": "headache, fever",
  "age": 25,
  "gender": "male",
  "medicalConditions": "none",
  "smoke": false,
  "activity": "moderate",
  "alcohol": false,
  "medication": false,
  "medicationList": "",
  "allergies": "none",
  "allergyLabel": "",
  "bloodPressure": "120/80 (80)",
  "spo2": 98,
  "etco2": 40.0,
  "peripheralPulse": 75,
  "respirationRate": 16
}
```
- The backend will log all received vitals for verification.

---

## Deployment (Railway)
- Deploy both the backend and Node.js AI service as separate Railway projects.
- Set environment variables (e.g., `OPENAI_API_KEY`) in Railway dashboard.
- Use the public Railway endpoints in your frontend and backend configs.
- Logs and errors can be viewed in the Railway dashboard.

---

## Future Improvements
- Add authentication and authorization.
- Add persistent logging and monitoring.
- Containerize with Docker for deployment.
- Expand LifeBot integration and add more sensors.
- Add automated tests and CI/CD.

---

## Contributors
- [Your Name]
- [Colleague 1: LifeBot]
- [Colleague 2: Trustr/ChatGPT]

---

## License
[Specify your license here]
