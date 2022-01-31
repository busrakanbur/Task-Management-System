/**
 *
 * @author nolen
 */
public class Team {
    
    private int team_id;
    private String team_name;

    public Team(int team_id, String team_name) {
        this.team_id = team_id;
        this.team_name = team_name;
    }

    public Team(String team_name) {
        this.team_name = team_name;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "team_id":             return team_id;
            case "team_name":           return team_name;
            default:                    return null;
	}
    }
    
    @Override
    public String toString() {
        return "team_id: " + team_id 
                + ", team_name: " + team_name;
    }

}
