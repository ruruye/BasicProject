
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageDAO {

	// 회사에서 고객 정보 및 예약내역 보여주기
	public List<ReservationsVO> getReservationList(String comId) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "test", "test");
		String sql = "select  A. RESVE_NO, B.CST_NAME, B.CST_TELNO, B.CST_ADD, A.RESVE_SERVICE, A.RESVE_DATE,A.WORK_AREA, A.RESVE_COST from Reservation A, Customer B,  Company C where C.COM_ID = A.COM_ID AND A.CST_ID = B.CST_ID AND C.COM_ID=? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, comId);
		ResultSet resultSet = ps.executeQuery();
		List<ReservationsVO> list = new ArrayList<>();
		while (resultSet.next()) {
			String no = resultSet.getString("RESVE_NO");
			String name = resultSet.getString("CST_NAME");
			String telNum = resultSet.getString("CST_TELNO");
			String add = resultSet.getString("CST_ADD");
			String service = resultSet.getString("RESVE_SERVICE");
			Date date = resultSet.getDate("RESVE_DATE");
			int area = resultSet.getInt("WORK_AREA");
			int cost = resultSet.getInt("RESVE_COST");
			list.add(new ReservationsVO(no, name, telNum, add, service, date, area, cost));
		}
		resultSet.close();
		ps.close();
		connection.close();

		return list;
	}
	
	// 회사에서 직원 목록 보여주기
	public List<EmployeeVO> getEmployeeList(String comId) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "test","test");
		
		String sql = "select A.EMP_ID, A.EMP_NAME, A.EMP_IHIDNUM, A.EMP_TELNO, A.EMP_EMAIL, A.EMP_ADD, A.EMP_HIREDATE "
				+ " FROM EMPLOYEE A , COMPANY B " + "WHERE A.COM_ID = B.COM_ID " + "AND A.COM_ID=? ";

		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, comId);
		ResultSet resultSet = ps.executeQuery();
		List<EmployeeVO> list = new ArrayList<>();
		while (resultSet.next()) {
			String id = resultSet.getString("EMP_ID");
			String name = resultSet.getString("EMP_NAME");
			String ihidNum = resultSet.getString("EMP_IHIDNUM");
			String telNo = resultSet.getString("EMP_TELNO");
			String email = resultSet.getString("EMP_EMAIL");
			String add = resultSet.getString("EMP_ADD");
			Date hireDate = resultSet.getDate("EMP_HIREDATE");
			list.add(new EmployeeVO(name, ihidNum, telNo, email, add, hireDate,comId));
		}
		resultSet.close();
		ps.close();
		connection.close();
		return list;
	}
//관리자 로그인 아이디 비번 설정 
	// 해당 아이디가 어느 사업자 번호와 매칭되는지 확인 받아야함
}




