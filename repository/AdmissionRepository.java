package com.smartcare.hms.repository;
import com.smartcare.hms.Entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {}