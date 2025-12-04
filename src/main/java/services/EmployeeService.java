package services;

import java.util.ArrayList;
import java.util.List;
import models.Employee;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    // CREATE
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // READ
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // READ by ID
    public Employee getEmployee(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateEmployee(int id, String newName, String newDept, double newSalary) {
        Employee emp = getEmployee(id);
        if (emp != null) {
            emp.setName(newName);
            emp.setDepartment(newDept);
            emp.setSalary(newSalary);
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deleteEmployee(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}
