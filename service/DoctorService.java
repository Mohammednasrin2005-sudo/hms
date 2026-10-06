package com.smartcare.hms.service;

import com.smartcare.hms.Entity.Doctor;
import com.smartcare.hms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setDoctorName(updatedDoctor.getDoctorName());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            doctor.setQualification(updatedDoctor.getQualification());
            doctor.setConsultationFee(updatedDoctor.getConsultationFee());
            doctor.setContactNumber(updatedDoctor.getContactNumber());
            return doctorRepository.save(doctor);
        }).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}