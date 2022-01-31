/**
 *
 * @author nolen
 */
public class Role {
  
    private int role_id;
    private String role_name;

    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "role_id":             return role_id;
            case "role_name":           return role_name;
            default:                    return null;
	}
    }
    
    @Override
    public String toString() {
        return "role_id: " + role_id 
                + ", role_name: " + role_name;
    }

}
