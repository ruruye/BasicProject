
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ListDAO {
	public List<ReservationVO> getMemos() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe","test","test");
		Statement statement = connection.createStatement();
		String sql = "SELECT RESVE_NO, RESVE_SERVICE, RESVE_DATE, WORK_AREA, RESVE_COST From RESERVATION";
		ResultSet resultSet = statement.executeQuery(sql);
		List<ReservationVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String no = resultSet.getString("RESVE_NO");
			String service = resultSet.getString("RESVE_SERVICE");
			Date resveDate = resultSet.getDate("RESVE_DATE");
			int workarea = resultSet.getInt("WORK_AREA");
			int resveCost= resultSet.getInt("RESVE_COST");
			
			list.add(new ReservationVO(no, service, resveDate, workarea, resveCost));
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
}
