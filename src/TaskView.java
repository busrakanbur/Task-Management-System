import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TaskView implements ViewInterface {

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
		return new ViewData("ManagerLoginMenuView", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
                System.out.println();
                System.out.println("Id\tName\tProject Id   Priority\tStart Date\tEnd Date\tStatus\t  Description");
                if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column first_name
				short task_id = resultSet.getShort("task_id");
                                String task_name = resultSet.getString("task_name");
                                Integer project_id = resultSet.getInt("project_id");
                                int priority = resultSet.getInt("priority");
                                String task_start_date = resultSet.getString("task_start_date");
                                String task_end_date = resultSet.getString("task_end_date");
                                String task_description = resultSet.getString("task_description");
                                int task_status = resultSet.getInt("task_status");
                                
                                
				// Display values
				System.out.print(task_id + "\t");
				System.out.print(task_name + "\t     ");
                                System.out.print(project_id + "\t\t ");
                                System.out.print(priority + "\t");
				System.out.print(task_start_date + "\t");
				System.out.print(task_end_date + "\t ");
                                System.out.print(" %" + task_status + "\t  ");
                                System.out.print(task_description + "\t");
				
				System.out.println();
			}
			resultSet.close();	
		}
		                
		return new ViewData("ManagerLoginMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("ManagerLoginMenu", "");
	}        

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("ManagerLoginMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("ManagerLoginMenu", "");
	}	
	
        Map<String, Object> getWhereParameters() throws Exception {
            
		System.out.println("\nEnter the task informations..");
		Integer task_id = getInteger("Task Id : ", true);// short task id ama useraccount integer olduğu için aynı şekilde yapıldı
                String task_name = getString("Task Name : ", true);
                Integer project_id = getInteger("Project ID : ", true);
                Integer priority = getInteger("Priority : ", true);
                String task_description = getString("Description : ", true);
                String task_start_date = getString("Task Start Date : ", true);
                String task_end_date = getString("Task End Date : ", true);
                
                Integer task_status = getInteger("Status : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();                
		if (task_id != null) whereParameters.put("task_id", task_id);
		if (task_name != null) whereParameters.put("task_name", task_name);
                if (task_id != null) whereParameters.put("project_id", project_id);
                if (task_id != null) whereParameters.put("priority", priority);
		if (task_start_date != null) whereParameters.put("task_start_date", task_start_date);
		if (task_end_date != null) whereParameters.put("task_end_date", task_end_date);
		if (task_description != null) whereParameters.put("task_description", task_description);
		if (task_status != null) whereParameters.put("task_status", task_status);
                               
		return whereParameters;
	}
        
        ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Task", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
                
		parameters.put("fieldNames", "task_name, project_id, priority, task_description, task_start_date, task_end_date, task_status");
		List<Object> rows = new ArrayList<>();
		
                String task_name, task_start_date, task_end_date, task_description;
                Integer task_status, priority, project_id;
                
		do
		{
			System.out.println("Add Task");
                        
                        task_name = getString("Task Name : ", true);
                        project_id = getInteger("Project Id : ", true);
                        priority = getInteger("Priority : ", true);
                        task_description = getString("Description : ", true);
                        task_start_date = getString("Task Start Date (yy/mm/dd) : ", true);
                        task_end_date = getString("Task End Date (yy/mm/dd): ", true);                        
                        task_status = getInteger("Status : ", true);                    
                        
			System.out.println();
					
			if (task_name != null && project_id != null && priority != null && task_start_date != null && task_end_date != null && task_description != null && task_status != null) {
				rows.add(new Task(task_name, project_id, priority, task_description, task_start_date, task_end_date, task_status));
			}
		}
		while (task_name != null && project_id != null && priority!= null && task_start_date != null && task_end_date != null && task_description != null && task_status != null);
                
                parameters.put("rows", rows);
		
		return new ViewData("Task", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Enter new task informations");
		String task_name = getString("Task Name : ", true);
		Integer project_id = getInteger("Project Id : ", true);
		Integer priority = getInteger("Priority : ", true);
                String task_description = getString("Description : ", true);
                String task_start_date = getString("Task Start Date : ", true);
                String task_end_date = getString("Task End Date : ", true);                
                Integer task_status = getInteger("Status : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
                if (task_name != null) updateParameters.put("task_name", task_name);
                if (project_id != null) updateParameters.put("project_id", project_id);
                if (priority != null) updateParameters.put("priority ", priority );
		if (task_start_date != null) updateParameters.put("task_start_date", task_start_date);
                if (task_end_date != null) updateParameters.put("task_end_date", task_end_date);
		if (task_description != null) updateParameters.put("task_description", task_description);
		if (task_status != null) updateParameters.put("task_status", task_status);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Task", "update", parameters);
	}
        
        ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Task", "delete", parameters);
	}
        
        @Override
	public String toString() {
		return "Task View";
	}		
}
