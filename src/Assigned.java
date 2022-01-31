/**
 *
 * @author nolen
 */
public class Assigned {
    
    private int assigned_id;
    private int task_id;
    private int employee_id;
    private int role_id;

    public Assigned() {
        
    }

    public Assigned(int assigned_id, int task_id, int employee_id, int role_id) {
        this.assigned_id = assigned_id;
        this.task_id = task_id;
        this.employee_id = employee_id;
        this.role_id = role_id;
    }

    public Assigned(int task_id, int employee_id, int role_id) {
        this.task_id = task_id;
        this.employee_id = employee_id;
        this.role_id = role_id;
    }

    public int getAssigned_id() {
        return assigned_id;
    }

    public void setAssigned_id(int assigned_id) {
        this.assigned_id = assigned_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "Assigned{" + "assigned_id=" + assigned_id + ", task_id=" + task_id + ", employee_id=" + employee_id + ", role_id=" + role_id + '}';
    }
    
    
    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "assigned_id":          return assigned_id;
            case "task_id":        return task_id;
            case "employee_id":  return employee_id;
            case "role_id":    return role_id;
            default:                    return null;
	}
    }

}
