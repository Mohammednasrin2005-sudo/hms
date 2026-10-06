package com.smartcare.hms.service;

import com.smartcare.hms.Entity.Admission;
import com.smartcare.hms.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    public Admission saveAdmission(Admission admission) {
        return admissionRepository.save(admission);
    }

    public Admission getAdmissionById(Long id) {
        return admissionRepository.findById(id).orElse(null);
    }

    public Admission updateAdmission(Long id, Admission updatedAdmission) {
        return admissionRepository.findById(id).map(adm -> {
            adm.setBedNumber(updatedAdmission.getBedNumber()); // <-- இந்த வரியைச் சேர்க்கவும்
            adm.setAdmissionDate(updatedAdmission.getAdmissionDate());
            adm.setDischargeDate(updatedAdmission.getDischargeDate());
            adm.setStatus(updatedAdmission.getStatus());
            return admissionRepository.save(adm);
        }).orElseThrow(() -> new RuntimeException("Admission not found"));
    }

    public void deleteAdmission(Long id) {
        admissionRepository.deleteById(id);
    }
}