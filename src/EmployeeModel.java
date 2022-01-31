
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
		sql.append("	project_id, project_name, project_start_date, project_end_date, project_description, project_status ");
		sql.append(" FROM dbo.Project ");

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		sql.append("ORDER BY project_id");
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
