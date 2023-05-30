
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {


	public CustomerVO getLogin(CustomerVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "test", "test");
		String sql = "select CST_ID, CST_PW, CST_NAME, CST_TELNO, CST_EMAIL, CST_ADD from CUSTOMER where rtrim(CST_ID) = ? and cst_pw = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getId());
		statement.setString(2, vo.getPw());
		ResultSet resultSet = statement.executeQuery();
		CustomerVO customer = null;
		if (resultSet.next()) {
			String id = resultSet.getString("CST_ID");
			String pw = resultSet.getString("CST_PW");
			String name = resultSet.getString("CST_NAME");
			String telno = resultSet.getString("CST_TELNO");
			String email = resultSet.getString("CST_EMAIL");
			String add = resultSet.getString("CST_ADD");
			customer = new CustomerVO(id, pw, name, telno, email, add);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return customer;
	}
	public CustomerVO getComLogin(CustomerVO v1) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "test", "test");
		String sql = "select COM_ID, COM_PW, COM_NAME, COM_TELNO, COM_EMAIL, COM_ADD, Rep_NAME from COMPANY where rtrim(COM_ID) = ? and com_pw = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, v1.getId());
		statement.setString(2, v1.getPw());
		ResultSet resultSet = statement.executeQuery();
		CompanyVO company = null;
		if (resultSet.next()) {
			String id = resultSet.getString("COM_ID");
			String pw = resultSet.getString("COM_PW");
			String name = resultSet.getString("COM_NAME");
			String telno = resultSet.getString("COM_TELNO");
			String email = resultSet.getString("COM_EMAIL");
			String add = resultSet.getString("COM_ADD");
			String repname = resultSet.getString("REP_NAME");
			company = new CompanyVO(id, pw, name, telno, email, add, repname);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return company;
	}
}