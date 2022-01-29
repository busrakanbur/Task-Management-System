/**
 *
 * @author nolen
 */
public class Employee extends UserAccount{
    
    private short employee_id;
    private short employee_code;
    private String employee_name;

    public Employee() {
    }

    public Employee(short employee_id, short employee_code, String employee_name) {
        this.employee_id = employee_id;
        this.employee_code = employee_code;
        this.employee_name = employee_name;
    }

    public Employee(short employee_id, short employee_code, String employee_name, String username, String password, String email, String first_name, String last_name, String is_project_manager) {
        super(username, password, email, first_name, last_name, is_project_manager);
        this.employee_id = employee_id;
        this.employee_code = employee_code;
        this.employee_name = employee_name;
    }

    public Employee(short employee_id, short employee_code, String employee_name, short user_account_id, String username, String password, String email, String first_name, String last_name, String is_project_manager) {
        super(user_account_id, username, password, email, first_name, last_name, is_project_manager);
        this.employee_id = employee_id;
        this.employee_code = employee_code;
        this.employee_name = employee_name;
    }

    public short getEmployee_id() { return employee_id; }

    public void setEmployee_id(short employee_id) { this.employee_id = employee_id; }

    public short getEmployee_code() { return employee_code; }

    public void setEmployee_code(short employee_code) { this.employee_code = employee_code; }

    public String getEmployee_name() { return employee_name; }

    public void setEmployee_name(String employee_name) { this.employee_name = employee_name; }

    @Override
    public String toString() {
        return "Employee{" + "employee_id=" + employee_id + ", employee_code=" + employee_code + ", employee_name=" + employee_name + '}';
    }
    
    
    
    
    
    
    
}
