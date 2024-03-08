package com.example.SpringBoot.service.Impl;

import com.example.SpringBoot.config.Loggable;
import com.example.SpringBoot.domain.CreateEmployeeRequest;
import com.example.SpringBoot.repository.EmployeeRepository;
import com.example.SpringBoot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Loggable(value = LogLevel.INFO)
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public String createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        return employeeRepository.createEmployee(createEmployeeRequest);
    }
}
