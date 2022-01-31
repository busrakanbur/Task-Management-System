import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TeamMemberView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
                    
		case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);	
		case "delete": return deleteOperation(modelData);
                
		case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);
                
		}		
		return new ViewData("TeamMemberMenuView", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
                System.out.println();
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Id\tTeam Id\t   Employee Id\t  Role Id");
                if (resultSet != null) {
			while (resultSet.next()) {				
                                int team_member_id = resultSet.getInt("team_member_id");
                                int team_id = resultSet.getInt("team_id");
                                int employee_id = resultSet.getInt("employee_id");
                                int role_id = resultSet.getInt("role_id");                                
                                
				// Display values
				System.out.print(team_member_id + "\t");
				System.out.print(team_id + "\t   ");
				System.out.print(employee_id + "\t\t  ");
                                System.out.print(role_id + "\t");
				
				System.out.println();
			}
			resultSet.close();	
		}
		                
		return new ViewData("TeamMemberMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("TeamMemberMenu", "");
	}        

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("TeamMemberMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("TeamMemberMenu", "");
	}	
	
        Map<String, Object> getWhereParameters() throws Exception {
            
		System.out.println("Enter the team member informations..");
		Integer team_id = getInteger("Team Id : ", true);
                Integer employee_id = getInteger("Employee Id : ", true);
                Integer role_id = getInteger("Role Id : ", true);                
                
		
		Map<String, Object> whereParameters = new HashMap<>();                
		if (team_id != null) whereParameters.put("team_id", team_id);
                if (employee_id != null) whereParameters.put("employee_id", employee_id);
                if (role_id != null) whereParameters.put("role_id", role_id);
		
                return whereParameters;
	}
        
        ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("TeamMember", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
                
		parameters.put("fieldNames", "team_id, employee_id, role_id");
		List<Object> rows = new ArrayList<>();
		
                Integer team_id, employee_id, role_id;
                
		do
		{
			System.out.println("Add Team Member");
                        
                        team_id = getInteger("Team Id : ", true);
                        employee_id = getInteger("Employee Id : ", true);
                        role_id = getInteger("Role Id : ", true);
                        System.out.println();
                        
                        if (team_id != null && employee_id != null && role_id != null) {
				rows.add(new TeamMember(team_id, employee_id, role_id));
			}
		}
		while (team_id != null && employee_id != null && role_id!= null);
                
                parameters.put("rows", rows);
		
		return new ViewData("TeamMember", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception { return null; }
        
        ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("TeamMember", "delete", parameters);
	}
        
        @Override
	public String toString() {
		return "Team Member View";
	}		
}
