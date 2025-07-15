package com.smarthealth.health_monitor.repository;

import com.smarthealth.health_monitor.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
