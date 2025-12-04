package services;

import models.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService service;

    @BeforeEach
    void setUp() {
        service = new EmployeeService();
    }

    @Test
    void addAndGetAllEmployees() {
        service.addEmployee(new Employee(1, "Alice", "HR", 40000));
        service.addEmployee(new Employee(2, "Bob", "IT", 50000));

        List<Employee> all = service.getAllEmployees();
        assertEquals(2, all.size());
    }

    @Test
    void getEmployeeById() {
        service.addEmployee(new Employee(10, "Carol", "Finance", 60000));
        Employee e = service.getEmployee(10);
        assertNotNull(e);
        assertEquals("Carol", e.getName());
    }

    @Test
    void updateEmployeeSucceeds() {
        service.addEmployee(new Employee(20, "Dave", "Sales", 45000));
        boolean updated = service.updateEmployee(20, "Davey", "Sales", 48000);
        assertTrue(updated);
        Employee e = service.getEmployee(20);
        assertEquals("Davey", e.getName());
        assertEquals(48000, e.getSalary());
    }

    @Test
    void updateEmployeeFailsForMissing() {
        boolean updated = service.updateEmployee(999, "X", "Y", 0);
        assertFalse(updated);
    }

    @Test
    void deleteEmployee() {
        service.addEmployee(new Employee(30, "Eve", "Support", 35000));
        boolean deleted = service.deleteEmployee(30);
        assertTrue(deleted);
        assertNull(service.getEmployee(30));
    }
}
