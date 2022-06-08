package com.employee_api.controller;

import com.employee_api.model.Employee;
import com.employee_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/v1.0.0/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping(path = "/add")
    public @ResponseBody String addEmployee(@RequestBody Employee receivedEmployee){
     return employeeService.addEmployee(receivedEmployee);
    }
    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteEmployee(@RequestBody Employee receivedEmployee){
        return employeeService.deleteEmployee(receivedEmployee);
    }
    @GetMapping(path = "/list")
    public @ResponseBody List<Employee> fetchEmployeeList(){
        return  employeeService.fetchEmployeeList();
    }
    @PutMapping(path = "/edit")
    public @ResponseBody String editEmployee(@RequestBody Employee receivedEmployee){
        return employeeService.editEmployee(receivedEmployee);
    }

}
