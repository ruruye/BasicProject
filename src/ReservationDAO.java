
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationDAO {
	public void reservation(String cstID) { // 신규예약
		Scanner scanner = new Scanner(System.in);
		CustomerVO vo = new CustomerVO();
		int resveCost = 0;
		while (true) {
			try {
				System.out.print("\n====================================================\n\n");
				System.out.print("                    [ 신규예약 ]               \n\n");
				System.out.print("  ・ 희망서비스(ex: 원룸/가정집/사무실): ");
				String resveService = scanner.nextLine();
				System.out.print("  ・ 희망일자(ex: 0000-00-00): ");
				String resveDate = scanner.nextLine();
				System.out.print("  ・ 작업평수: ");
				int workArea = Integer.parseInt(scanner.nextLine());
				resveCost = workArea * 6000;
				int com;
				//업체 번호가 1에서 5 사이의 값이 아니면 다시 입력받게 하려고 반복문 사용함
				while (true) {
					System.out.println("  < 업체목록 >");
					System.out.println("  ➊ 백마청소   ➋ 미소청소   ➌ 아트크린");
					System.out.println("  ➍ 태광청소박사    ➎ 한스클린");
					System.out.print("  ・ 희망업체(번호): ");
					com = Integer.parseInt(scanner.nextLine());
					if (com < 1 || com > 5) {
						System.out.println("\n      [오류] 올바른 업체 번호를 입력하세요.\n");
					} else {
						break;
					}
				}
				String comId = null;
				switch (com) {
				case 1:
					comId = "baekma";
					break;
				case 2:
					comId = "getmiso";
					break;
				case 3:
					comId = "artclean";
					break;
				case 4:
					comId = "taekwang";
					break;
				case 5:
					comId = "hansclean";
					break;
				}
				System.out.println("\n----------------------------------------------------\n");
				System.out.println("입력하신 내용으로 예약을 진행하시겠습니까? (y/n)");
				System.out.print("선택> ");
				String yesOrNo = scanner.nextLine();
				if (yesOrNo.equalsIgnoreCase("y")) {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "test",
							"test");
					Statement seqStatement = connection.createStatement();
					ResultSet resultSet = seqStatement.executeQuery(
							"select to_char(sysdate, 'yymmdd') || lpad(rev_seq.nextval, 3, '0') from dual");
					String resveNo = null;

					if (resultSet.next()) {
						resveNo = resultSet.getString(1);
					}

					StringBuilder builder = new StringBuilder();
					builder.append("insert into reservation values (?, ?, ?, ?, ?, ?, ?)");
					String sql = builder.toString();
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, resveNo);
					statement.setString(2, resveService);
					statement.setString(3, resveDate);
					statement.setInt(4, workArea);
					statement.setInt(5, resveCost);
					statement.setString(6, ReservationApplication.getSession().getId());
					statement.setString(7, comId);

					statement.executeUpdate();
					statement.close();
					connection.close();
					System.out.println("\n            * 예약이 완료되었습니다 *");
					System.out.println("       예약하신 서비스의 요금은 " + resveCost + "원입니다\n");
				}else {
					System.out.println("\n            * 예약이 취소되었습니다 *");
					run();
				}
//				System.out.println("예약하신 서비스의 요금은: " + resveCost + "입니다.\n\n");
				break;
			} catch (NumberFormatException e) {
//			e.printStackTrace();
			} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("올바르지 않은 정보를 입력했습니다. 다시 입력해주세요.");
			}

		}
//		System.out.println("\n          * 예약이 완료되었습니다 *");
//		System.out.println("       예약하신 서비스의 요금은 " + resveCost + "원 입니다.\n");
		
	}

	private void run() {
		// TODO Auto-generated method stub
		
	}

	public List<ReservationVO> getReservationList() throws Exception { // 회원 에약내역 select
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "test", "test");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    a.resve_no, ");
		builder.append("    a.resve_service, ");
		builder.append("    a.resve_date, ");
		builder.append("    a.work_area, ");
		builder.append("    a.resve_cost, ");
		builder.append("    b.com_name ");
		builder.append("FROM ");
		builder.append("    reservation a, ");
		builder.append("    company     b ");
		builder.append("WHERE ");
		builder.append("    a.com_id = b.com_id ");
		builder.append("    AND a.cst_id = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, ReservationApplication.getSession().getId());
		//
		ResultSet resultSet = statement.executeQuery();
		List<ReservationVO> list = new ArrayList<>();
		while (resultSet.next()) {
			String no = resultSet.getString("RESVE_NO");
			String service = resultSet.getString("RESVE_SERVICE");
			Date date = resultSet.getDate("RESVE_DATE");
			int area = resultSet.getInt("WORK_AREA");
			int cost = resultSet.getInt("RESVE_COST");
			String comName = resultSet.getString("com_name");
			list.add(new ReservationVO(no, service, date, area, cost, comName));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public int deleteCustomer(String deleteId) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "test", "test");
		String sql = "DELETE from customer WHERE cst_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, deleteId);
		// statement 객체에 select(조회): executeQuery(), insert, update, delete:
		// executeUpdate()
		int count = statement.executeUpdate();
		statement.close();
		connection.close();
		return count;
	}

}
