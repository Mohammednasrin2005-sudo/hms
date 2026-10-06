package com.smartcare.hms.service;

import com.smartcare.hms.Entity.Treatment;
import com.smartcare.hms.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Treatment saveTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public Treatment getTreatmentById(Long id) {
        return treatmentRepository.findById(id).orElse(null);
    }

    public Treatment updateTreatment(Long id, Treatment updatedTreatment) {
        return treatmentRepository.findById(id).map(t -> {
            t.setTreatmentName(updatedTreatment.getTreatmentName());
            t.setDescription(updatedTreatment.getDescription());
            t.setDiagnosis(updatedTreatment.getDiagnosis());
            t.setPrescriptionDetails(updatedTreatment.getPrescriptionDetails()); // <-- இந்த வரியைச் சேர்க்கவும்
            t.setCost(updatedTreatment.getCost());
            t.setTreatmentDate(updatedTreatment.getTreatmentDate());
            return treatmentRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("Treatment not found"));
    }

    public void deleteTreatment(Long id) {
        treatmentRepository.deleteById(id);
    }
}