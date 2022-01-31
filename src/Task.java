/**
 *
 * @author nolen
 */
public class Task {
    
    private short task_id;
    private String task_name;
    private int project_id;
    private int priority;
    private String task_description;
    private String task_start_date;
    private String task_end_date;
    private int task_status;

    public Task(short task_id, String task_name, int project_id, int priority, String task_description, String task_start_date, String task_end_date, int task_status) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.project_id = project_id;
        this.priority = priority;
        this.task_description = task_description;
        this.task_start_date = task_start_date;
        this.task_end_date = task_end_date;
        this.task_status = task_status;
    }

    public Task(String task_name, int project_id, int priority, String task_description, String task_start_date, String task_end_date, int task_status) {
        this.task_name = task_name;
        this.project_id = project_id;
        this.priority = priority;
        this.task_description = task_description;
        this.task_start_date = task_start_date;
        this.task_end_date = task_end_date;
        this.task_status = task_status;
    }

    public short getTask_id() { return task_id; }

    public void setTask_id(short task_id) { this.task_id = task_id; }

    public String getTask_name() { return task_name; }

    public void setTask_name(String task_name) { this.task_name = task_name; }

    public int getProject_id() { return project_id; }

    public void setProject_id(int project_id) { this.project_id = project_id; }

    public int getPriority() { return priority; }

    public void setPriority(int priority) { this.priority = priority; }

    public String getTask_description() { return task_description; }

    public void setTask_description(String task_description) { this.task_description = task_description; }

    public String getTask_start_date() { return task_start_date; }

    public void setTask_start_date(String task_start_date) { this.task_start_date = task_start_date; }

    public String getTask_end_date() { return task_end_date; }

    public void setTask_end_date(String task_end_date) { this.task_end_date = task_end_date; }

    public int getTask_status() { return task_status; }

    public void setTask_status(int task_status) { this.task_status = task_status; }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "task_id":             return task_id;
            case "task_name":           return task_name;
            case "project_id":          return project_id;
            case "priority":            return priority;
            case "task_description":    return task_description;
            case "task_start_date":     return task_start_date;
            case "task_end_date":       return task_end_date;
            case "task_status":         return task_status;
            default:                    return null;
	}
    }
    
    @Override
    public String toString() {
        return "Task Id: " + task_id 
                + ", Task Name: " + task_name 
                + ", Project Id: " + project_id 
                + ", Priority: " + priority 
                + ", Task Description: " + task_description 
                + ", Task Start Date: " + task_start_date 
                + ", Task End Date: " + task_end_date 
                + ", Task Status:" + task_status;
    }

}
