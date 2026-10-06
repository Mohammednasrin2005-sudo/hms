package com.smartcare.hms.service;

import com.smartcare.hms.Entity.Department;
import com.smartcare.hms.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, Department updatedDept) {
        return departmentRepository.findById(id).map(dept -> {
            dept.setDepartmentName(updatedDept.getDepartmentName());
            dept.setLocation(updatedDept.getLocation());
            return departmentRepository.save(dept);
        }).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}