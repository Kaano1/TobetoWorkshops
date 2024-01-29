package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.dtos.request.Employee.AddEmployeeRequest;
import com.tobeto.rentacar.services.dtos.request.Employee.UpdateEmployeeRequest;
import com.tobeto.rentacar.services.dtos.response.Employee.GetEmployeeListResponse;
import com.tobeto.rentacar.services.dtos.response.Employee.GetEmployeeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
    private final EmployeeService employeeService;

    @GetMapping("getAll")
    List<GetEmployeeListResponse> getAll()
    {
        return employeeService.getAll();
    }

    @GetMapping("getById/{id}")
    GetEmployeeResponse getById(@PathVariable int id)
    {
        return employeeService.getById(id);
    }

    @PostMapping
    void    add(@RequestBody @Valid AddEmployeeRequest addEmployeeRequest)
    {
        employeeService.add(addEmployeeRequest);
    }

    @PutMapping
    void    update(@RequestBody @Valid UpdateEmployeeRequest updateEmployeeRequest) { employeeService.update(updateEmployeeRequest); }

    @DeleteMapping("delete/{id}")
    void    delete(@PathVariable int id)
    {
        employeeService.delete(id);
    }
}
