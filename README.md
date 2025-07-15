# smart-health-monitor
# 🩺 Health Monitor Application

This is a full-stack Spring Boot application for managing patient data and vital records. It includes:

- A PostgreSQL database
- A REST API
- A Thymeleaf-based HTML UI
- Entity relationships (One-to-Many: Patient → Vital Records)

---

## 📁 Project Structure

```
health-monitor/
├── src/
│   ├── main/
│   │   ├── java/com/smarthealth/health_monitor/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── HealthMonitorApplication.java
│   │   └── resources/
│   │       ├── static/index.html
│   │       ├── templates/          # Thymeleaf HTML templates
│   │       ├── application.properties
│   │       └── application.yml
├── target/
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven
- PostgreSQL
- pgAdmin (optional)
- Postman (for testing REST APIs)

---

## 🔧 Setup Instructions

### 1. Clone the project

```bash
git clone https://github.com/yourusername/health-monitor.git
cd health-monitor
```

### 2. Configure PostgreSQL

- Create a database named `healthdb`
- Inside pgAdmin or SQL Shell:

```sql
CREATE DATABASE healthdb;
```

### 3. Update `application.properties`

Edit `src/main/resources/application.properties`:

```properties
spring.application.name=health-monitor
spring.datasource.url=jdbc:postgresql://localhost:5432/healthdb
spring.datasource.username=your_pg_username
spring.datasource.password=your_pg_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧬 Model Overview

### Patient

```java
@Entity
public class Patient {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private String email;
}
```

### VitalRecord

```java
@Entity
public class VitalRecord {
    @Id @GeneratedValue
    private Long id;
    private int heartRate;
    private int systolicPressure;
    private int diastolicPressure;
    private LocalDateTime timestamp;

    @ManyToOne
    private Patient patient;
}
```

---

## 📡 REST API Endpoints

| Method | Endpoint              | Description             |
|--------|-----------------------|-------------------------|
| GET    | `/api/patients`       | List all patients       |
| POST   | `/api/patients`       | Add new patient         |
| GET    | `/api/vitals`         | List all vitals         |
| POST   | `/api/vitals`         | Add vitals for patient  |

Use **Postman** or browser to test GET requests and form submission.

---

## 🎨 Thymeleaf UI (Spring MVC)

- Static HTML and templates are placed under:
  - `src/main/resources/static/index.html`
  - `src/main/resources/templates/patient_form.html`, etc.

- Example controller for UI:

```java
@Controller
public class WebController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient_form";
    }

    @PostMapping("/patients/save")
    public String savePatient(@ModelAttribute Patient patient) {
        patientRepo.save(patient);
        return "redirect:/";
    }
}
```

---

## ✅ Status

-  RESTful API working
-  Database connection successful
-  Thymeleaf UI integrated


---

## 🛠️ Technologies Used

- Java 17
- Spring Boot 3.5.x
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Lombok
- Maven

---


## 🧪 Running the App

```bash
./mvnw spring-boot:run
```

Then visit:

- Backend API: `http://localhost:8080/api/patients`
- Frontend UI: `http://localhost:8080/`

---
