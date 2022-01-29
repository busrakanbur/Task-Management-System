
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nolen
 */
public class EmployeeModel implements ModelInterface {
    
    @Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("	user_account_id, username, password, email, first_name, last_name, is_project_manager ");
		sql.append(" FROM dbo.UserAccount ");

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		sql.append("ORDER BY user_account_id");		
		//System.out.println(sql.toString() + "\n");

		
		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
		ResultSet result = preparedStatement.executeQuery();
		
		return result;
	}
		
	@Override
	public int insert(String fieldNames, List<Object> rows) throws Exception { return 0; }
        
        @Override
	public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception { return 0; }

	@Override
	public int delete(Map<String,Object> whereParameters) throws Exception { return 0; }
        
        @Override
	public int signup(String fieldNames, List<Object> rows) throws Exception { return 0; }
        
        @Override
	public ResultSet signin(Map<String, Object> whereParameters) throws Exception { return null; }
        
        @Override
	public String toString() { return "Employee Model"; }    
}
