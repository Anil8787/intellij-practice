package com.api_example.controller;

import com.api_example.dto.EmployeeDto;
import com.api_example.entity.Employee;
import com.api_example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/employee")
@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController( EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //http://localhost:8085/api/v1/employee/save
    @PostMapping("/save")
    public String saveData(@RequestBody EmployeeDto employeeDto ){
        employeeService.saveDataToDB(employeeDto);
        return "saved";
    }
    @GetMapping("/read")      //Because you are using @RestController, Spring will automatically convert the List into JSON.
    public  List<Employee> readEmployee(){
        return employeeService.readEmployees();
    }
    @GetMapping("/read/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
//    @GetMapping("/read")//GET http://localhost:8080/read?id=10 it will be accessable
//    public Employee getEmployeeById(@RequestParam Long id) {
//        return employeeService.getEmployeeById(id);
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "record deleted successfully...";
    }
   @PutMapping("/update/{id}")
    public String updateEmployeeById(@RequestBody EmployeeDto employeeDto,@PathVariable Long id){
        employeeService.updateEmployeeById(employeeDto,id);
        return "record updated Successfully...";
   }






}
