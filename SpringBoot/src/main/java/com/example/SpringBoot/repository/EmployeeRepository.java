package com.example.SpringBoot.repository;

import com.example.SpringBoot.domain.CreateEmployeeRequest;

public interface EmployeeRepository {
    String createEmployee(CreateEmployeeRequest createEmployeeRequest);
}
