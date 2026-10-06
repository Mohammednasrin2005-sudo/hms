package com.smartcare.hms.service;

import com.smartcare.hms.Entity.Appointment;
import com.smartcare.hms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment updateAppointment(Long id, Appointment updatedApp) {
        return appointmentRepository.findById(id).map(app -> {
            app.setAppointmentDate(updatedApp.getAppointmentDate());
            app.setAppointmentTime(updatedApp.getAppointmentTime());
            app.setAppointmentStatus(updatedApp.getAppointmentStatus());
            app.setConsultationRoom(updatedApp.getConsultationRoom());
            return appointmentRepository.save(app);
        }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}