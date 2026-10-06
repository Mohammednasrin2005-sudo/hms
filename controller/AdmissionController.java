package com.smartcare.hms.controller;

import com.smartcare.hms.Entity.Admission;
import com.smartcare.hms.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @GetMapping
    public List<Admission> getAllAdmissions() {
        return admissionService.getAllAdmissions();
    }

    @PostMapping
    public Admission createAdmission(@RequestBody Admission admission) {
        return admissionService.saveAdmission(admission);
    }

    @GetMapping("/{id}")
    public Admission getAdmissionById(@PathVariable Long id) {
        return admissionService.getAdmissionById(id);
    }

    @PutMapping("/{id}")
    public Admission updateAdmission(@PathVariable Long id, @RequestBody Admission admission) {
        return admissionService.updateAdmission(id, admission);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmission(@PathVariable Long id) {
        admissionService.deleteAdmission(id);
        return "Admission deleted successfully!";
    }
}