package com.smartcare.hms.controller;

import com.smartcare.hms.Entity.Treatment;
import com.smartcare.hms.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @GetMapping
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }

    @PostMapping
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        return treatmentService.saveTreatment(treatment);
    }

    @GetMapping("/{id}")
    public Treatment getTreatmentById(@PathVariable Long id) {
        return treatmentService.getTreatmentById(id);
    }

    @PutMapping("/{id}")
    public Treatment updateTreatment(@PathVariable Long id, @RequestBody Treatment treatment) {
        return treatmentService.updateTreatment(id, treatment);
    }

    @DeleteMapping("/{id}")
    public String deleteTreatment(@PathVariable Long id) {
        treatmentService.deleteTreatment(id);
        return "Treatment deleted successfully!";
    }
}