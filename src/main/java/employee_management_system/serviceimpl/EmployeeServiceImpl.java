package employee_management_system.serviceimpl;
import employee_management_system.service.EmployeeService;

import java.util.List;

import org.springframework.stereotype.Service;
import employee_management_system.exception.EmployeeNotFoundException;
import employee_management_system.entity.Employee;

import employee_management_system.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    // Constructor Injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    
    @Override
    public Employee saveEmployee(Employee employee) {
    	

        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }


    @Override
    public Employee updateEmployee(Employee employee) {

    	Employee existingEmployee = employeeRepository
    	        .findById(employee.getId())
    	        .orElseThrow(() -> new EmployeeNotFoundException(employee.getId()));


        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setJoiningDate(employee.getJoiningDate());


        return employeeRepository.save(existingEmployee);
    }


    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        employeeRepository.delete(employee);
    }
}