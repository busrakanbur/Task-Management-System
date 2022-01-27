
import java.util.Date;


abstract class UserAccount {
    
    private short user_account_id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private String is_project_manager;
	
    UserAccount() {
        
    }
	
    UserAccount(String username, String password, String email, String first_name, String last_name, String is_project_manager) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.is_project_manager = is_project_manager;
    }  

    UserAccount(short user_account_id, String username, String password, String email, String first_name, String last_name, String is_project_manager) {
        this.user_account_id = user_account_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.is_project_manager = is_project_manager;
    }       


    public short getUser_account_id() { return user_account_id; }

    public void setUser_account_id(short user_account_id) { this.user_account_id = user_account_id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getFirst_name() { return first_name; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String isIs_project_manager() { return is_project_manager; }

    public void setIs_project_manager(String is_project_manager) { this.is_project_manager = is_project_manager; }

    
    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "user_account_id": return user_account_id;
            case "username": return username;
            case "password": return password;
            case "email": return email;
            case "first_name": return first_name;
            case "last_name": return last_name;
            case "is_project_manager": return is_project_manager;
            default: return null;
	}
    }
        
    @Override
    public String toString() {
        return user_account_id + ", " + username + ", " + password + ", " + email + ", " + first_name + ", " + last_name + ", " + is_project_manager;
    }
	
}