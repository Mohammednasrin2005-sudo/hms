package com.smartcare.hms.service;

import com.smartcare.hms.Entity.Laboratory;
import com.smartcare.hms.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public List<Laboratory> getAllTests() {
        return laboratoryRepository.findAll();
    }

    public Laboratory saveTest(Laboratory lab) {
        return laboratoryRepository.save(lab);
    }

    public Laboratory getTestById(Long id) {
        return laboratoryRepository.findById(id).orElse(null);
    }

    public Laboratory updateTest(Long id, Laboratory updatedLab) {
        return laboratoryRepository.findById(id).map(lab -> {
            lab.setTestName(updatedLab.getTestName());
            lab.setTestResult(updatedLab.getTestResult());
            lab.setTestDate(updatedLab.getTestDate());
            return laboratoryRepository.save(lab);
        }).orElseThrow(() -> new RuntimeException("Lab record not found"));
    }

    public void deleteTest(Long id) {
        laboratoryRepository.deleteById(id);
    }
}