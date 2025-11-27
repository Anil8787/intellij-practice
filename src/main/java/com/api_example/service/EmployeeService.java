package com.api_example.service;




import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.api_example.dto.EmployeeDto;
import com.api_example.entity.Employee;
import com.api_example.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveDataToDB(EmployeeDto employeeDto) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(employeeDto ,emp);
        employeeRepository.save(emp);
    }
    public List<Employee> readEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return  employeeRepository.findById(id).orElseThrow();
    }
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
    public void updateEmployeeById(EmployeeDto employeeDto, Long id){
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(employeeDto.getName());
        emp.setEmail(employeeDto.getEmail());
        emp.setMobile(employeeDto.getMobile());
        employeeRepository.save(emp);
    }




}
