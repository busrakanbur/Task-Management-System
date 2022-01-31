
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


class TeamView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
                    
		case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);                
                
		case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "update.gui": return updateGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);                                
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
                System.out.println("User List");
                
                /*
                private int team_id;
                private String team_name;

                */
                
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column first_name
				short team_id = resultSet.getShort("team_id");// kendi classında int burada short
                                String team_name = resultSet.getString("team_name");
                                
				
				// Display values
				System.out.print(team_id + "\t");
				System.out.print(team_name + "\t");

                                System.out.println();
			}
			resultSet.close();	
		}
		                
		return new ViewData("TeamMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("TeamMenu", "");
	}        

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("TeamMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("TeamMenu", "");
	}	
	
        ViewData signinOperation(ModelData modelData) throws Exception { return null; }
        
        ViewData signupOperation(ModelData modelData) throws Exception { return null; }
        
        Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Enter the team informations..");
		Integer team_id = getInteger("Team Id : ", true);
                String team_name = getString("Team Name : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();                
		if (team_id != null) whereParameters.put("team_id", team_id);
		if (team_name != null) whereParameters.put("team_name", team_name);
                               
		return whereParameters;
	}
        
        ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Team", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "team_id, team_name");
		List<Object> rows = new ArrayList<>();
		
		String team_name;
		do
		{	System.out.println("Add Team");                        
                        team_name = getString("Team Name : ", true);                                              
			System.out.println();
					
			if (team_name != null) {
				rows.add(new Team(team_name) {});
			}
		}
		while (team_name != null);
                
                parameters.put("rows", rows);
		
		return new ViewData("Team", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception { return null;	}
        
        ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Team", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Team View";
	}		
}
