
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


class RoleView implements ViewInterface {

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
		
		return new ViewData("RoleMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
                System.out.println("User List");
                
                /*
                private int role_id;
                private String role_name;

                */
                
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column first_name
				short role_id = resultSet.getShort("role_id");// kendi classında int burada short
                                String role_name = resultSet.getString("role_name");
                                
				
				// Display values
				System.out.print(role_id + "\t");
				System.out.print(role_name + "\t");

                                System.out.println();
			}
			resultSet.close();	
		}
		                
		return new ViewData("RoleMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("RoleMenu", "");
	}        

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("RoleMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("RoleMenu", "");
	}	
	
        ViewData signinOperation(ModelData modelData) throws Exception { return null; }
        
        ViewData signupOperation(ModelData modelData) throws Exception { return null; }
        
        Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Enter the role informations..");
		Integer role_id = getInteger("Role Id : ", true);
                String role_name = getString("Role Name : ", true);

		Map<String, Object> whereParameters = new HashMap<>();                
		if (role_id != null) whereParameters.put("role_id", role_id);
		if (role_name != null) whereParameters.put("role_name", role_name);

                return whereParameters;
	}
        
        ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Role", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "role_id, role_name");
		List<Object> rows = new ArrayList<>();
		
		String role_name;
		do
		{       System.out.println("Add Role");                        
                        role_name = getString("Role Name : ", true);                                              
			System.out.println();
					
			if (role_name != null) {
				rows.add(new Role(role_name) {});
			}
		}
		while (role_name != null);
                
                parameters.put("rows", rows);
		
		return new ViewData("Role", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception { return null;	}
        
        ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Role", "delete", parameters);
	}

        @Override
	public String toString() {
		return "User Account View";
	}		
}
