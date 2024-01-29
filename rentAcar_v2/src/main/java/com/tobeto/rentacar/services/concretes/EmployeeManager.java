package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilites.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Employee;
import com.tobeto.rentacar.repository.EmployeeRepository;
import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.dtos.request.Employee.AddEmployeeRequest;
import com.tobeto.rentacar.services.dtos.request.Employee.UpdateEmployeeRequest;
import com.tobeto.rentacar.services.dtos.response.Employee.GetEmployeeListResponse;
import com.tobeto.rentacar.services.dtos.response.Employee.GetEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetEmployeeListResponse> getAll()
    {
        List<Employee> employees = employeeRepository.findAll();
        return (employees.stream()
                .map(employee -> this.modelMapperService.forResponse()
                        .map(employee, GetEmployeeListResponse.class))
                .collect(Collectors.toList()));
    }

    @Override
    public GetEmployeeResponse getById(int id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return modelMapperService.
                forResponse().map(employee, GetEmployeeResponse.class);
    }
    @Override
    public void    add(AddEmployeeRequest addEmployeeRequest)
    {
        Employee employee = modelMapperService.forRequest().map(addEmployeeRequest, Employee.class);
        employeeRepository.save(employee);
    }
    @Override
    public void    update(UpdateEmployeeRequest updateEmployeeRequest)
    {
        Employee employee = modelMapperService.forRequest().
                map(updateEmployeeRequest, Employee.class);
        employeeRepository.save(employee);
    }
    @Override
    public void     delete(int id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow();

        employeeRepository.delete(employee);
    }
}
