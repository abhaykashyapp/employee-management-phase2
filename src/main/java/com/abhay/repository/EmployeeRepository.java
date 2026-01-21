package com.abhay.repository;

import com.abhay.model.Employee;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    private static final String FILE_NAME = "employees.dat";


    private Map<Integer, Employee> employeeStore = new HashMap<>();

    public EmployeeRepository() {

        loadFromFile();
    }

    public void save(Employee employee) {
        employeeStore.put(employee.getId(), employee);
        saveToFile();

    }

    public Employee findById(int id) {
        return employeeStore.get(id);

    }

    public void deleteById(int id) {
         employeeStore.remove(id);
        saveToFile();
    }

    //checking if id already exist
    public boolean exists(int id) {
        return employeeStore.containsKey(id);
    }

    private void saveToFile() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employeeStore);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employeeStore = (Map<Integer, Employee>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    public Collection<Employee> findAll() {
        return employeeStore.values();
    }
}
