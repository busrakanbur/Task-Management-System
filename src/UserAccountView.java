
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class UserAccountView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
                    
		/*case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);*/                
		/*case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "update.gui": return updateGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);*/
                case "signup": return signupOperation(modelData);
                case "signin": return signinOperation(modelData);
                case "signin.gui": return signinGUI(modelData);
                case "signup.gui": return signupGUI(modelData);
                
		}
		
		return new ViewData("MainMenu", "");
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
	
        ViewData signinOperation(ModelData modelData) throws Exception {
		//System.out.println("signing in... " + modelData.recordCount);		
		
                ResultSet resultSet = modelData.resultSet;

                if (resultSet != null) {
                    while (resultSet.next()) {
                                        String username = resultSet.getString("username");
                                        String password = resultSet.getString("password");
                        // Display values
                        System.out.print(username + "\t");
                        System.out.print(password + "\t");
                                        System.out.println();
                    }
                    resultSet.close();
                }
                
                /*if(resultSet == null) {
                    return new ViewData("MainMenu", "");
                    
                }*/
                 
                return new ViewData("ManagerLoginMenu", "");
	}
        
        ViewData signupOperation(ModelData modelData) throws Exception {
		System.out.println("Number of sign up operation is " + modelData.recordCount);
		
		return new ViewData("MainMenu", ""); //denemek için böyle yaptım, bu kısım sigin'de çalışmıyor çünkü fonksiyonu yazamadım.
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
        
        Map<String, Object> getWhereParameters_forsignin() throws Exception {
		
                System.out.println("SIGN IN");
                String username = getString("username : ", true);
                String password = getString("password : ", true);      
                
                Map<String, Object> whereParameters = new HashMap<>();
		if (username != null) whereParameters.put("username", username);
		if (password != null) whereParameters.put("password", password);
                
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("UserAccount", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "username, password, email, first_name, last_name, is_project_manager");

		List<Object> rows = new ArrayList<>();
		
		String username, password, email, first_name, last_name, is_project_manager;
		do
		{
			System.out.println("Fields to insert:");
                        
                        username = getString("username : ", true);
                        password = getString("password : ", true);
                        email = getString("email : ", true);
                        first_name = getString("first_name : ", true);
                        last_name = getString("last_name : ", true);
                        is_project_manager = getString("is_project_manager :", true);                       
                        
			System.out.println();
					
			if (username != null && password != null && email != null && first_name != null && last_name != null && is_project_manager != null) {
				rows.add(new UserAccount(username, password, email, first_name, last_name, is_project_manager) {});
			}
		}
		while (username != null && password != null && email != null && first_name != null && last_name != null && is_project_manager != null);
                
                parameters.put("rows", rows);
		
		return new ViewData("UserAccount", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String username = getString("username : ", true);
                String password = getString("password : ", true);
                String email = getString("email : ", true);
                String first_name = getString("first_name : ", true);
                String last_name = getString("last_name : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
                if (username != null) updateParameters.put("username", username);
		if (password != null) updateParameters.put("password", password);
                if (email != null) updateParameters.put("email", email);
		if (first_name != null) updateParameters.put("first_name", first_name);
		if (last_name != null) updateParameters.put("last_name", last_name);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("UserAccount", "update", parameters);
	}
        
        ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("UserAccount", "delete", parameters);
	}
        
        ViewData signinGUI(ModelData modelData) throws Exception {           
                Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters_forsignin());
                
                if(parameters.isEmpty())
		return new ViewData("UserAccount", "signin", parameters);
                
                return null;
	}

	ViewData signupGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "username, password, email, first_name, last_name, is_project_manager");

		List<Object> rows = new ArrayList<>();
		
		String username, password, email, first_name, last_name, is_project_manager;
		do
		{
			System.out.println("SIGN UP");                        
                        username = getString("Username : ", true);
                        password = getString("Password : ", true);
                        email = getString("Email : ", true);
                        first_name = getString("First Name : ", true);
                        last_name = getString("Last Name : ", true);
                        is_project_manager = getString("Is Project Manager:", true);                      
                        
			System.out.println();
					
			if (username != null && password != null && email != null && first_name != null && last_name != null && is_project_manager != null) {
				rows.add(new UserAccount(username, password, email, first_name, last_name, is_project_manager) {});
			}
		}
		while (username != null && password != null && email != null && first_name != null && last_name != null && is_project_manager != null);
                
                parameters.put("rows", rows);
		
		return new ViewData("UserAccount", "signup", parameters);
	}

	@Override
	public String toString() {
		return "User Account View";
	}		
}
