package employee_management_system.exception;

public class EmployeeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmployeeNotFoundException(Long id){
        super("Employee not found with id : "+id);
    }
}