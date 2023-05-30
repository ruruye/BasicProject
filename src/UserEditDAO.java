import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import oracle.jdbc.driver.parser.Tuple;

public class UserEditDAO {
	public void useredit(String id) throws Exception {
		MypageView mypageView = new MypageView();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n====================================================\n");
			System.out.println("                   [ 정보수정 ]\n");
			System.out.println(" ➊ 비밀번호 ➋ 전화번호 ➌ 이메일 ➍ 주소 ➎ 나가기\n");
			System.out.println("====================================================");
			System.out.print("선택> ");
			String menu = scanner.nextLine();
			System.out.println();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe","test","test");
			StringBuilder builder = new StringBuilder();
			String editData = null;
			if (menu.equals("1")) {
				System.out.print("변경할 비밀번호: ");
				editData = scanner.nextLine();
				builder.append("update customer set cst_pw = ? where cst_id = ?");
				String sql = builder.toString();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1,editData);
				statement.setString(2, id);
				statement.executeUpdate();
				statement.close();
				connection.close();
				System.out.println("* 비밀번호 수정이 완료되었습니다 *");
				useredit(id);
				break;
			} else if (menu.equals("2")) {
				System.out.print("변경할 전화번호: (ex: 000-0000-0000): ");
				editData = scanner.nextLine();
				builder.append("update customer set cst_telno = ? where cst_id = ?");
				String sql = builder.toString();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1,editData);
				statement.setString(2, id);
				statement.executeUpdate();
				statement.close();
				connection.close();
				System.out.println("* 전화번호 수정이 완료되었습니다 *");
				useredit(id);
				break;
			} else if (menu.equals("3")) {
				System.out.print("이메일을 수정하세요: ");
				editData = scanner.nextLine();
				builder.append("update customer set cst_email = ? where cst_id = ?");
				String sql = builder.toString();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1,editData);
				statement.setString(2, id);
				statement.executeUpdate();
				statement.close();
				connection.close();
				System.out.println("* 이메일 수정이 완료되었습니다 *");
				useredit(id);
				break;
			} else if (menu.equals("4")) {
				System.out.print("주소를 수정하세요: ");
				editData = scanner.nextLine();
				builder.append("update customer set cst_add = ? where cst_id = ?");
				String sql = builder.toString();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1,editData);
				statement.setString(2, id);
				statement.executeUpdate();
				statement.close();
				connection.close();
				System.out.println("* 주소 수정이 완료되었습니다 *");
				useredit(id);
				break;
			} else if (menu.equals("5")) {
				mypageView.run();
			} else {
				System.out.println("! 잘못된 입력입니다 !\n");
			}

		}

	}
}
