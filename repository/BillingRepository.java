package com.smartcare.hms.repository;
import com.smartcare.hms.Entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {}