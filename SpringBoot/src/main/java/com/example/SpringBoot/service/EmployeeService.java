package com.example.SpringBoot.service;

import com.example.SpringBoot.domain.CreateEmployeeRequest;

public interface EmployeeService {
    String createEmployee(CreateEmployeeRequest createEmployeeRequest);
}
