import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ProjectView implements ViewInterface {

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
                
                if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column first_name
				short project_id = resultSet.getShort("project_id");
                                String project_name = resultSet.getString("project_name");
                                String project_start_date = resultSet.getString("project_start_date");
                                String project_end_date = resultSet.getString("project_end_date");
                                String project_description = resultSet.getString("project_description");
                                int project_status = resultSet.getInt("project_status");
                                
				// Display values
				System.out.print(project_id + "\t");
				System.out.print(project_name + "\t");
				System.out.print(project_start_date + "\t");
				System.out.print(project_end_date + "\t");
                                System.out.print(project_description + "\t");
				System.out.print(project_status + "\t");
				
                                System.out.println();
			}
			resultSet.close();	
		}
		                
		return new ViewData("MainMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}        

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}	
	
        Map<String, Object> getWhereParameters() throws Exception {
            
		System.out.println("Filter conditions:");
		Integer project_id = getInteger("project_id : ", true);// short project id ama useraccount integer olduğu için aynı şekilde yapıldı
                String project_name = getString("project_name : ", true);
                String project_start_date = getString("project_start_date : ", true);
                String project_end_date = getString("project_end_date : ", true);
                String project_description = getString("project_description : ", true);
                Integer project_status = getInteger("project_status : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();                
		if (project_id != null) whereParameters.put("project_id", project_id);
		if (project_name != null) whereParameters.put("project_name", project_name);
		if (project_start_date != null) whereParameters.put("project_start_date", project_start_date);
		if (project_end_date != null) whereParameters.put("project_end_date", project_end_date);
		if (project_description != null) whereParameters.put("project_description", project_description);
		if (project_status != null) whereParameters.put("project_status", project_status);
                               
		return whereParameters;
	}
        
        ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Project", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
                
		parameters.put("fieldNames", "project_name, project_start_date, project_end_date, project_description, project_status");
		List<Object> rows = new ArrayList<>();
		
		String project_name, project_start_date, project_end_date, project_description;
                Integer project_status;
		do
		{
			System.out.println("Fields to insert:");
                        
                        project_name = getString("project_name : ", true);
                        project_start_date = getString("project_start_date : ", true);
                        project_end_date = getString("project_end_date : ", true);
                        project_description = getString("project_description : ", true);
                        project_status = getInteger("project_status : ", true);                    
                        
			System.out.println();
					
			if (project_name != null && project_start_date != null && project_end_date != null && project_description != null && project_status != null) {
				rows.add(new Project(project_name, project_start_date, project_end_date, project_description, project_status) {});
			}
		}
		while (project_name != null && project_start_date != null && project_end_date != null && project_description != null && project_status != null);
                
                parameters.put("rows", rows);
		
		return new ViewData("Project", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String project_name = getString("project_name : ", true);
                String project_start_date = getString("project_start_date : ", true);
                String project_end_date = getString("project_end_date : ", true);
                String project_description = getString("project_description : ", true);
                Integer project_status = getInteger("project_status : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
                if (project_name != null) updateParameters.put("project_name", project_name);
		if (project_start_date != null) updateParameters.put("project_start_date", project_start_date);
                if (project_end_date != null) updateParameters.put("project_end_date", project_end_date);
		if (project_description != null) updateParameters.put("project_description", project_description);
		if (project_status != null) updateParameters.put("project_status", project_status);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Project", "update", parameters);
	}
        
        ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Project", "delete", parameters);
	}
        
        @Override
	public String toString() {
		return "Project View";
	}		
}