/**
 *
 * @author nolen
 */
public class TeamMember {
    
    private int team_member_id;
    private int team_id;
    private int employee_id;
    private int role_id;

    public TeamMember(int team_member_id, int team_id, int employee_id, int role_id) {
        this.team_member_id = team_member_id;
        this.team_id = team_id;
        this.employee_id = employee_id;
        this.role_id = role_id;
    }

    public TeamMember(int team_id, int employee_id, int role_id) {
        this.team_id = team_id;
        this.employee_id = employee_id;
        this.role_id = role_id;
    }

    public int getTeam_member_id() {
        return team_member_id;
    }

    public void setTeam_member_id(int team_member_id) {
        this.team_member_id = team_member_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
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

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "team_member_id":             return team_member_id;
            case "team_id":           return team_id;
            case "employee_id":          return employee_id;
            case "role_id":            return role_id;
            default:                    return null;
	}
    }
    
    @Override
    public String toString() {
        return "Task Id: " + team_member_id 
                + ", Task Name: " + team_id 
                + ", Project Id: " + employee_id 
                + ", Priority: " + role_id;
    }

}
