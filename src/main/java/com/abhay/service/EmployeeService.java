package com.abhay.service;

import com.abhay.model.Employee;
import com.abhay.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class EmployeeService {

@Autowired
private EmployeeRepository repository ;


    public void addEmployee(int id, String name, double salary) {

        if (repository.exists(id)) {
            throw new IllegalArgumentException("Employee already exists");
        }
        repository.save(new Employee(id, name, salary));
    }

    public  void  updateEmployee(int id , String name, double salary){

        Employee employee = repository.findById(id);
        if (employee==null){
            throw  new IllegalArgumentException("Employee not Found!!!" );
        }
        employee.setName(name);
        employee.setSalary(salary       );

    }
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
    public Collection<Employee> listEmployees() {
        return repository.findAll();
    }
}
