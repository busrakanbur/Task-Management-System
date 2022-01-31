import java.sql.*;
import java.util.*;

class UserAccountModel implements ModelInterface {
	
	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("	employee_id, employee_code, employee_name, user_account_id ");
		sql.append(" FROM dbo.Employee ");

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		sql.append("ORDER BY employee_id");		
		//System.out.println(sql.toString() + "\n");

		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
		ResultSet result = preparedStatement.executeQuery();
		
		return result;
	}
        
        @Override
	public int insert(String fieldNames, List<Object> rows) throws Exception
	{
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO dbo.UserAccount (" + fieldNames + ") " );
		sql.append(" VALUES ");

		String[] fieldList = fieldNames.split(",");

		int rowCount = 0;
		for (int i=0; i<rows.size(); i++) {
			if (rows.get(i) instanceof UserAccount) {
				rowCount++;
                                
				
				UserAccount userAccount = (UserAccount)rows.get(i); 
	
				sql.append("(");
				for (int j=0; j<fieldList.length; j++) {
					String fieldName = fieldList[j].trim();
					sql.append(DatabaseUtilities.formatField(userAccount.getByName(fieldName)));
					if (j < fieldList.length - 1) {
						sql.append(", ");
					}
				}
				sql.append(")");
				
				if (i < rows.size() - 1) {
					sql.append(", ");
				}				
			}
		}		
		System.out.println(sql.toString());
		
		if (rowCount > 0) {
			Connection connection = DatabaseUtilities.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			rowCount = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
               
		return rowCount;
	}
        
        @Override
	public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
	{
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE dbo.UserAccount SET ");
		int appendCount = 0;
		for (Map.Entry<String, Object> entry : updateParameters.entrySet()) {
			sql.append(entry.getKey() + " = " + DatabaseUtilities.formatField(entry.getValue()));
			if (++appendCount < updateParameters.size()) {
				sql.append(", ");
			}
		}
		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		//System.out.println(sql.toString());
		
	
		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);		
		int rowCount = preparedStatement.executeUpdate();
		preparedStatement.close();
		
		return rowCount;
	}

	@Override
	public int delete(Map<String,Object> whereParameters) throws Exception
	{
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM dbo.UserAccount ");

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		//System.out.println(sql.toString());

	
		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);		
		int rowCount = preparedStatement.executeUpdate();
		preparedStatement.close();
		
		return rowCount;
	}
        
         @Override
	public ResultSet signin(Map<String, Object> whereParameters) throws Exception
	{		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("	username, password, is_project_manager");
		sql.append(" FROM dbo.UserAccount ");

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		//sql.append("ORDER BY user_account_id");		
		System.out.println(sql.toString() + "\n");

		
		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
		ResultSet result = preparedStatement.executeQuery();
		
		return result;
	}
        
        @Override
	public int signup(String fieldNames, List<Object> rows) throws Exception
	{
		// construct SQL statement
            
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO dbo.UserAccount (" + fieldNames + ") " );
		sql.append(" VALUES ");

		String[] fieldList = fieldNames.split(",");

		int rowCount = 0;
		for (int i=0; i<rows.size(); i++) {
			if (rows.get(i) instanceof UserAccount) {
				rowCount++;
				
				UserAccount department = (UserAccount)rows.get(i); 
	
				sql.append("(");
				for (int j=0; j<fieldList.length; j++) {
					String fieldName = fieldList[j].trim();
					sql.append(DatabaseUtilities.formatField(department.getByName(fieldName)));
					if (j < fieldList.length - 1) {
						sql.append(", ");
					}
				}
				sql.append(")");
				
				if (i < rows.size() - 1) {
					sql.append(", ");
				}				
			}
		}
                /*
                List<Object> rows2 = new ArrayList<>();
                
		String fieldNames2 = "project_id";
                StringBuilder sql2 = new StringBuilder();
		sql2.append(" INSERT INTO dbo.Manager (" + "project_id" + ") " );
		sql2.append(" VALUES ");
                
                String[] fieldList2 = fieldNames2.split(",");

		int rowCount2 = 0;
		for (int i=0; i<rows.size(); i++) {
			if (rows.get(i) instanceof Manager) {
				rowCount2++;
				
				Manager manager = (Manager)rows.get(i); 
	
				sql2.append("(");
				for (int j=0; j<fieldList2.length; j++) {
					String fieldName2 = fieldList2[j].trim();
					sql2.append(DatabaseUtilities.formatField(manager.getByName(fieldName2)));
					if (j < fieldList2.length - 1) {
						sql2.append(", ");
					}
				}
				sql2.append(")");
				
				if (i < rows.size() - 1) {
					sql2.append(", ");
				}				
			}
		}
                Short project_id = 0;
                
                rows2.add(new Manager(project_id) {});
		*/
                
                // execute constructed SQL statement
		if (rowCount > 0) {
			Connection connection = DatabaseUtilities.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			rowCount = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		
		return rowCount;
	}
        
        @Override
	public String toString() {
		return "User Account Model";
	}
}
