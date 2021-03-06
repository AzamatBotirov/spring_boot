package com.salom.vasalim.service;

import com.salom.vasalim.demain.Employee;
import com.salom.vasalim.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public  Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findByNameQueryNative(name);
    }

    public List<Employee> findAllByParam(String name){
        return employeeRepository.findByNameEndingWith(name);
    }

    public void delete(Long id){
        Employee employee = employeeRepository.getOne(id);
        employeeRepository.delete(employee);
    }

    @Scheduled(cron ="0 31 23 * * *")
        public Employee saveSchedule(){
        Employee employee = new Employee();
        employee.setName("sssssss");
        employee.setLastName("tttttt");
        return employeeRepository.save(employee);
    }

    public List<String> getAsList() {
        File parentDir = new File("c:\\dev");
        return Arrays.asList(parentDir.list());
    }

}

