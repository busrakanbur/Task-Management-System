/**
 *
 * @author nolen
 */
public class Project {
    
    private short project_id;
    private String project_name;
    private String project_start_date;
    private String project_end_date;
    private String project_description;
    private int project_status;

    public Project() {
        
    }

    public Project(short project_id, String project_name, String project_start_date, String project_end_date,  String project_description,int project_status) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_start_date = project_start_date;
        this.project_end_date = project_end_date;
        this.project_description = project_description;
        this.project_status = project_status;
    }
    public Project(String project_name, String project_start_date, String project_end_date,  String project_description,int project_status) {// bu constroctur ViewData insertGUI içindir.
        this.project_name = project_name;
        this.project_start_date = project_start_date;
        this.project_end_date = project_end_date;
        this.project_description = project_description;
        this.project_status = project_status;
    }

    public int getProject_status() { return project_status; }

    public void setProject_status(int project_status) { this.project_status = project_status; }

    public short getProject_id() { return project_id; }

    public void setProject_id(short project_id) { this.project_id = project_id; }

    public String getProject_name() { return project_name; }

    public void setProject_name(String project_name) { this.project_name = project_name; }

    public String getProject_start_date() { return project_start_date; }

    public void setProject_start_date(String project_start_date) { this.project_start_date = project_start_date; }

    public String getProject_end_date() { return project_end_date; }

    public void setProject_end_date(String project_end_date) { this.project_end_date = project_end_date; }

    public String getProject_description() { return project_description; }

    public void setProject_description(String project_description) { this.project_description = project_description; }
    
    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "project_id":          return project_id;
            case "project_name":        return project_name;
            case "project_start_date":  return project_start_date;
            case "project_end_date":    return project_end_date;
            case "project_description": return project_description;
            case "project_status":      return project_status;
            default:                    return null;
	}
    }

    @Override
    public String toString() {
        return "Project Id: " + project_id 
                + ", Project Name: " + project_name 
                + ", Project Start Date: " + project_start_date 
                + ", Project End Date: " + project_end_date 
                + ", Project Description: " + project_description;
    }
    
}
