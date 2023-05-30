

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class JoinDAO {
	private static JoinDAO instance = new JoinDAO();
	public static JoinDAO getInstance() {
		return instance;
	}
	private JoinDAO() {}
	
	public void JoinService(CustomerVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe","test","test");
		StringBuilder builder = new StringBuilder();
		builder.append("insert into CUSTOMER values (?, ?, ?, ?, ?, ?)");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getId());
		statement.setString(2, vo.getPw());
		statement.setString(3, vo.getName());
		statement.setString(4, vo.getTelno());
		statement.setString(5, vo.getEmail());
		statement.setString(6, vo.getAdd());
	
		statement.executeUpdate();
		
		statement.close();
		connection.close();

	}
	
	 public void DeleteAccount(String id) throws Exception {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe","test","test");
	        StringBuilder builder = new StringBuilder();
			builder.append("Delete from CUSTOMER where cst_id = ?");
			String sql = builder.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery(sql);
			
			statement.executeUpdate();
			
			resultSet.close();			
			statement.close();
			connection.close();
	
	      
	    }

}
	
//	}
//	
//	public int insertUser(Map<> param) {
//		String sql = "insert into CUSTOMER values (?,?,?,?,?,?)";
//		List<Object> p = new ArrayList<>();
//		p.add(param.get("CST_ID"));
//		p.add(param.get("CST_PW"));
//		p.add(param.get("CST_NAME"));
//		p.add(param.get("CST_TELNO"));
//		p.add(param.get("CST_EMAIL"));
//		p.add(param.get("CST_ADD"));
//		return jdbc.update(sql, p);
//	}
//	
//	public Map<String, Object> selectUser(String cstId, String cstPw) {
//		String sql = "select * from CUSTOMER where cst_id = ? and cst_pw = ?"; 
//		List<Object> param = new ArrayList<>();
//		param.add(cstId);
//		param.add(cstPw);
//		
//		return jdbc.selectOne(sql,param);
//	}
//	
//
//}
