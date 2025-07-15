package com.smarthealth.health_monitor.controller;

import com.smarthealth.health_monitor.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final List<Patient> patients = new ArrayList<>();

    @GetMapping
    public List<Patient> getAllPatients() {
        return patients;
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        patients.add(patient);
        return patient;
    }
}
