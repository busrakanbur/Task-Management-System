import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class AssignedView implements ViewInterface {

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
		return new ViewData("AssignedMenuView", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
                System.out.println();
                System.out.println("Id\tTask Id\t\tEmployee Id\tRole Id");
                if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column first_name
				int assigned_id = resultSet.getInt("assigned_id");
                                int task_id = resultSet.getInt("task_id");
                                int employee_id = resultSet.getInt("employee_id");
                                int role_id = resultSet.getInt("role_id");
                                
                                // Display values
				System.out.print(assigned_id + "\t");
                                System.out.print(task_id + "\t\t");
                                System.out.print(employee_id + "\t\t");
				System.out.print(role_id + "\t");				
                                System.out.println();
			}
			resultSet.close();	
		}
		                
		return new ViewData("AssignedMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("AssignedMenu", "");
	}        

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("AssignedMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("AssignedMenu", "");
	}	
	
        Map<String, Object> getWhereParameters() throws Exception {
            
		System.out.println("\nInformations to remove..");
		Integer assigned_id = getInteger("Assigned Id : ", true);
                Integer task_id = getInteger("Task Id : ", true);
                Integer employee_id = getInteger("Employee Id : ", true);
                Integer role_id = getInteger("Role Id : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();                
		if (assigned_id != null) whereParameters.put("assigned_id", assigned_id);
                if (task_id != null) whereParameters.put("task_id", task_id);
                if (employee_id != null) whereParameters.put("employee_id", employee_id);
                if (role_id != null) whereParameters.put("role_id", role_id);                
                               
		return whereParameters;
	}
        
        ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Assigned", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
                
		parameters.put("fieldNames", "task_id, employee_id, role_id");
		List<Object> rows = new ArrayList<>();
		
		Integer task_id, employee_id, role_id;
		do
		{
			System.out.println("Add Employee to a Task");
                        
                        task_id = getInteger("Task Id : ", true);
                        employee_id = getInteger("Employee Id : ", true);
                        role_id = getInteger("Role Id : ", true);
                        
			System.out.println();
					
			if (task_id != null && employee_id != null && role_id != null) {
				rows.add(new Assigned(task_id, employee_id, role_id) {});
			}
		}
		while (task_id != null && employee_id != null && role_id != null);
                
                parameters.put("rows", rows);
		
		return new ViewData("Assigned", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		return null;
	}
        
        ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Assigned", "delete", parameters);
	}
        
        @Override
	public String toString() {
		return "Assigned View";
	}		
}