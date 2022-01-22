
/**
 *
 * @author nolen
 */
public class Project {
    
    private short project_id;
    private String project_name;
    private String project_start_date;
    private String project_end_date;
    private String project_description = "";

    public Project() {
    }

    public Project(short project_id, String project_name, String project_start_date, String project_end_date) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_start_date = project_start_date;
        this.project_end_date = project_end_date;
    }

    public short getProject_id() {
        return project_id;
    }

    public void setProject_id(short project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_start_date() {
        return project_start_date;
    }

    public void setProject_start_date(String project_start_date) {
        this.project_start_date = project_start_date;
    }

    public String getProject_end_date() {
        return project_end_date;
    }

    public void setProject_end_date(String project_end_date) {
        this.project_end_date = project_end_date;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }
    
    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "project_id": return project_id;
            case "project_name": return project_name;
            case "project_start_date": return project_start_date;
            case "project_end_date": return project_end_date;
            case "project_description": return project_description;
            default: return null;
	}
    }

    @Override
    public String toString() {
        return "Project{" + "project_id=" + project_id + ", project_name=" + project_name + ", project_start_date=" + project_start_date + ", project_end_date=" + project_end_date + ", project_description=" + project_description + '}';
    }

    
}
