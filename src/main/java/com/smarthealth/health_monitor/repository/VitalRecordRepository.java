package com.smarthealth.health_monitor.repository;

import com.smarthealth.health_monitor.model.VitalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalRecordRepository extends JpaRepository<VitalRecord, Long> {
}
