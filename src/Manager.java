
/**
 *
 * @author nolen
 */
public class Manager extends UserAccount {
    
    private short manager_id;
    private short project_id;

    public Manager() {
    }

    public Manager(short project_id) {
        this.project_id = project_id;
    }

    public Manager(short manager_id, short project_id) {
        this.manager_id = manager_id;
        this.project_id = project_id;
    }

    public Manager(short manager_id, short project_id, String username, String password, String email, String first_name, String last_name, String is_project_manager) {
        super(username, password, email, first_name, last_name, is_project_manager);
        this.manager_id = manager_id;
        this.project_id = project_id;
    }

    public Manager(short manager_id, short project_id, short user_account_id, String username, String password, String email, String first_name, String last_name, String is_project_manager) {
        super(user_account_id, username, password, email, first_name, last_name, is_project_manager);
        this.manager_id = manager_id;
        this.project_id = project_id;
    }

    public short getManager_id() { return manager_id; }

    public void setManager_id(short manager_id) { this.manager_id = manager_id; }

    public short getProject_id() { return project_id; }

    public void setProject_id(short project_id) { this.project_id = project_id; }
    
    @Override
    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "manager_id": return manager_id;
            case "project_id": return project_id;
            default: return null;
	}
    }
    
    
    
    @Override
    public String toString() {
        return "Manager{" + "manager_id=" + manager_id + ", project_id=" + project_id + '}';
    }
    
    
    
    
    
    
    
}
