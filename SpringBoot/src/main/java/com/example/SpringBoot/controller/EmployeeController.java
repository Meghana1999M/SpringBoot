package com.example.SpringBoot.controller;

import com.example.SpringBoot.config.Loggable;
import com.example.SpringBoot.api.EmployeeApi;
import com.example.SpringBoot.domain.CreateEmployeeRequest;
import com.example.SpringBoot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.SpringBoot.constants.Constants.EMPLOYEE;

@RestController
@RequestMapping("/restServices/" + EMPLOYEE)
@RequiredArgsConstructor
@Loggable(value= LogLevel.INFO, result = false)
public class EmployeeController implements EmployeeApi {

    private final EmployeeService employeeService;
    @Override
    @PostMapping("/createEmployee")
    public ResponseEntity<String> createEmployee(CreateEmployeeRequest createEmployeeRequest){
        return ResponseEntity.ok("");
    }
}
