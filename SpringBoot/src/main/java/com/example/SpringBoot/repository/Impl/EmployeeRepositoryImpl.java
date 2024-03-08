package com.example.SpringBoot.repository.Impl;

import com.example.SpringBoot.domain.CreateEmployeeRequest;
import com.example.SpringBoot.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public String createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        return null;
    }
}
