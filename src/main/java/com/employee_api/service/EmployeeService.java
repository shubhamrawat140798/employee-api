package com.employee_api.service;

import com.employee_api.model.Employee;
import com.employee_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public String addEmployee(Employee receivedEmployee){
        String error="";
        if (receivedEmployee.getName() == "" || receivedEmployee.getName() == null){
            error += "[error] Name :empty\n";
        }
        if (receivedEmployee.getDepartment() == "" || receivedEmployee.getDepartment() == null){
            error += "[error] Department :empty\n";
        }
        if (receivedEmployee.getMobile() == "" || receivedEmployee.getMobile() == null){
            error += "[error] Mobile :empty\n";
        }
        if (error.equals("")){
            employeeRepository.save(receivedEmployee);
            return "Employee is added";
        }
        return error;
    }
    public String deleteEmployee(Employee receivedEmployee){
        if (employeeRepository.existsById(receivedEmployee.getId())){
            receivedEmployee = employeeRepository.getReferenceById(receivedEmployee.getId());
            employeeRepository.delete(receivedEmployee);
            return "Employee deleted";
        }
        return "Employee does not exist";
    }
    public List<Employee> fetchEmployeeList(){
        return employeeRepository.findAll();
    }
    public String editEmployee(Employee receivedEmployee){
        if (employeeRepository.existsById(receivedEmployee.getId())){
            Employee originalCopyEmployee= employeeRepository.getReferenceById(receivedEmployee.getId());
            if (receivedEmployee.getName() != null){
                originalCopyEmployee.setName(receivedEmployee.getName());
            }
            if(receivedEmployee.getMobile() != null){
                originalCopyEmployee.setMobile(receivedEmployee.getMobile());
            }
            if (receivedEmployee.getDepartment() != null){
                originalCopyEmployee.setDepartment(receivedEmployee.getDepartment());
            }
            if (receivedEmployee.getSalary() != 0){
                originalCopyEmployee.setSalary(receivedEmployee.getSalary());
            }
            employeeRepository.save(originalCopyEmployee);
            return "Edit successful";
        }
        return "Employee does not exist";
    }
}
