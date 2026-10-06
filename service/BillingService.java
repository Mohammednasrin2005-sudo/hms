package com.smartcare.hms.service;

import com.smartcare.hms.Entity.Billing;
import com.smartcare.hms.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    public Billing saveBill(Billing billing) {
        return billingRepository.save(billing);
    }

    public Billing getBillById(Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    public Billing updateBill(Long id, Billing updatedBill) {
        return billingRepository.findById(id).map(bill -> {
            bill.setTotalAmount(updatedBill.getTotalAmount());
            bill.setPaymentStatus(updatedBill.getPaymentStatus());
            bill.setBillDate(updatedBill.getBillDate());
            return billingRepository.save(bill);
        }).orElseThrow(() -> new RuntimeException("Bill record not found"));
    }

    public void deleteBill(Long id) {
        billingRepository.deleteById(id);
    }
}