package employee_management_system.service;

import java.util.List;

import employee_management_system.entity.Employee;

public interface EmployeeService {

    // Save Employee
    Employee saveEmployee(Employee employee);

    // Get All Employees
    List<Employee> getAllEmployees();

    // Get Employee By Id
    Employee getEmployeeById(Long id);

    // Update Employee
    Employee updateEmployee(Employee employee);

    // Delete Employee
    void deleteEmployee(Long id);
}