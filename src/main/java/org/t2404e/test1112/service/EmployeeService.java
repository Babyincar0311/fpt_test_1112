package org.t2404e.test1112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.t2404e.test1112.model.Employee;
import org.t2404e.test1112.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getEmployees() {
        return repo.findAll();
    }
    public void addEmployees(Employee e) {
        repo.save(e);
    }
    public void updateEmployee(Employee e) {
        repo.save(e);
    }
    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}
