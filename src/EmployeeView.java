
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
		case "select.gui": return selectGUI(modelData);
		}
		
		return new ViewData("EmployeeLoginMenuView", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column first_name
				short user_account_id = resultSet.getShort("user_account_id");
                                String username = resultSet.getString("username");
                                String password = resultSet.getString("password");
                                String email = resultSet.getString("email");
                                String first_name = resultSet.getString("first_name");
                                String last_name = resultSet.getString("last_name");
                                String is_project_manager = resultSet.getString("is_project_manager");
				
				// Display values
				System.out.print(user_account_id + "\t");
				System.out.print(username + "\t");
				System.out.print(password + "\t");
				System.out.print(email + "\t");
                                System.out.print(first_name + "\t");
				System.out.print(last_name + "\t");
				System.out.print(is_project_manager + "\t");
                                System.out.println();
			}
			resultSet.close();	
		}
		
		return new ViewData("EmployeeLoginMenu", "");
	}
	     
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		Integer user_account_id = getInteger("user_account_id : ", true);
                String username = getString("username : ", true);
                String password = getString("password : ", true);
                String email = getString("email : ", true);
                String first_name = getString("first_name : ", true);
                String last_name = getString("last_name : ", true);
                String is_project_manager = getString("is_project_manager :", true);
		
		Map<String, Object> whereParameters = new HashMap<>();                
		if (user_account_id != null) whereParameters.put("user_account_id", user_account_id);
		if (username != null) whereParameters.put("username", username);
		if (password != null) whereParameters.put("password", password);
		if (email != null) whereParameters.put("email", email);
		if (first_name != null) whereParameters.put("first_name", first_name);
		if (last_name != null) whereParameters.put("last_name", last_name);
                if (is_project_manager != null) whereParameters.put("is_project_manager", is_project_manager);
                
		return whereParameters;
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
