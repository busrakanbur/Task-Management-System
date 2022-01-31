
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nolen
 */
public class EmployeeView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
                    
		case "select": return selectOperation(modelData);
                case "update": return updateOperation(modelData);
		case "select.gui": return selectGUI(modelData);
                case "update.gui": return updateGUI(modelData);
		}
		
		return new ViewData("EmployeeLoginMenuView", "");
	}
	
        ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("EmployeeLoginMenu", "");
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
		                
		return new ViewData("EmployeeLoginMenu", "");
	}
	     
	Map<String, Object> getWhereParameters() throws Exception {
            
		System.out.println("\nEnter the task informations..");
		Integer task_id = getInteger("Task Id : ", true);
                String task_name = getString("Task Name : ", true);
                System.out.println();
		
		Map<String, Object> whereParameters = new HashMap<>();                
		if (task_id != null) whereParameters.put("task_id", task_id);
		if (task_name != null) whereParameters.put("task_name", task_name);
                               
		return whereParameters;
	}
        
        ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("\nChange status of your task..");              
                Integer task_status = getInteger("Status(%): ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (task_status != null) updateParameters.put("task_status", task_status);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Employee", "update", parameters);
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Employee", "select", parameters);
	}

	@Override
	public String toString() {
		return "Employee View";
	}
    
}
