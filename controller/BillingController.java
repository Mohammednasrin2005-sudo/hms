package com.smartcare.hms.controller;

import com.smartcare.hms.Entity.Billing; // அல்லது உங்கள் Billing Entity Package
import com.smartcare.hms.service.BillingService; // உங்கள் BillingService Package
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/billing")
@CrossOrigin(origins = "*")
public class BillingController {

    @Autowired
    private BillingService billingService;
    @GetMapping
    public List<Billing> getAllBills() {
        return billingService.getAllBills();
    }

    // 2. Create Bill
    @PostMapping
    public Billing createBill(@RequestBody Billing billing) {
        return billingService.saveBill(billing);
    }

    // 3. Get Bill by ID
    @GetMapping("/{id}")
    public Billing getBillById(@PathVariable Long id) {
        return billingService.getBillById(id);
    }

    // 4. Update Bill
    @PutMapping("/{id}")
    public Billing updateBill(@PathVariable Long id, @RequestBody Billing billing) {
        return billingService.updateBill(id, billing);
    }

    // 5. Delete Bill
    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        billingService.deleteBill(id);
        return "Billing record deleted successfully!";
    }
}