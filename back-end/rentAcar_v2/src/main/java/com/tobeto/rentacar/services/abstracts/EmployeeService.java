package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.request.Employee.AddEmployeeRequest;
import com.tobeto.rentacar.services.dtos.request.Employee.UpdateEmployeeRequest;
import com.tobeto.rentacar.services.dtos.response.Employee.GetEmployeeListResponse;
import com.tobeto.rentacar.services.dtos.response.Employee.GetEmployeeResponse;

import java.util.List;

public interface EmployeeService {

     List<GetEmployeeListResponse> getAll();
     GetEmployeeResponse getById(int id);
     void    add(AddEmployeeRequest addEmployeeRequest);
     void    update(UpdateEmployeeRequest updateEmployeeRequest);
     void     delete(int id);
}
