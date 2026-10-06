package com.smartcare.hms.repository;
import com.smartcare.hms.Entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {}
