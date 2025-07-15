package com.smarthealth.health_monitor.controller;

import com.smarthealth.health_monitor.model.Patient;
import com.smarthealth.health_monitor.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients/view")
    public String viewPatients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "patient-list"; // maps to templates/patient-list.html
    }

    @GetMapping("/patients/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-form";
    }

    @PostMapping("/patients/save")
    public String savePatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "redirect:/patients/view";
    }
}
