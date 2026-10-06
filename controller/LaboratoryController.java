package com.smartcare.hms.controller;

import com.smartcare.hms.Entity.Laboratory;
import com.smartcare.hms.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratory")
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;

    @GetMapping
    public List<Laboratory> getAllTests() {
        return laboratoryService.getAllTests();
    }

    @PostMapping
    public Laboratory createTest(@RequestBody Laboratory lab) {
        return laboratoryService.saveTest(lab);
    }

    @GetMapping("/{id}")
    public Laboratory getTestById(@PathVariable Long id) {
        return laboratoryService.getTestById(id);
    }

    @PutMapping("/{id}")
    public Laboratory updateTest(@PathVariable Long id, @RequestBody Laboratory lab) {
        return laboratoryService.updateTest(id, lab);
    }

    @DeleteMapping("/{id}")
    public String deleteTest(@PathVariable Long id) {
        laboratoryService.deleteTest(id);
        return "Laboratory record deleted successfully!";
    }
}