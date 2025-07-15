package com.smarthealth.health_monitor.controller;

import com.smarthealth.health_monitor.model.VitalRecord;
import com.smarthealth.health_monitor.repository.VitalRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vitals")
public class VitalRecordController {

    private final VitalRecordRepository repository;

    public VitalRecordController(VitalRecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<VitalRecord> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public VitalRecord create(@RequestBody VitalRecord vitalRecord) {
        return repository.save(vitalRecord);
    }
}
