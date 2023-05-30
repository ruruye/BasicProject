
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class MypageView {

	private static MypageView instance = new MypageView();
	private ReservationApplication main = ReservationApplication.getInstance();

	public MypageView() {
	}

	public static MypageView getInstance() {
		return instance;
	}

	public static void showMenu() {
		System.out.println("\n====================================================\n");
		System.out.println("                   [ 마이페이지 ]\n");
		System.out.println("                   ➊ 신규예약");
		System.out.println("                   ➋ 예약목록");
		System.out.println("                   ➌ 정보수정");
		System.out.println("                   ➍ 탈퇴");
		System.out.println("                   ➎ 로그아웃\n");
		System.out.println("====================================================");
	}

	public void run() throws Exception {
		Scanner scanner = new Scanner(System.in);
		String input;
		ReservationDAO dao = new ReservationDAO();
		UserEditDAO dao1 = new UserEditDAO();
		showMenu();

		while (true) {
			System.out.print("선택> ");
			input = scanner.nextLine();

			switch (input) {
			case "1":
				dao.reservation(ReservationApplication.getSession().getId()); // 신규예약 insert
				System.out.println("                  마이페이지로 이동합니다");
				System.out.println();
				run();
				break;
			case "2":
				List<ReservationVO> list = dao.getReservationList(); // 예약목록출력
				printReservationList(list);
				System.out.println("마이페이지로 돌아가시려면 [0]을 입력하세요.");
				System.out.print("선택> ");
				input = scanner.nextLine();
				if (input.equals("0")) {
					run();
				}
				break;
			case "3":
				dao1.useredit(ReservationApplication.getSession().getId());
				break;
			case "4":
				System.out.println("\n탈퇴하시겠습니까? (y/n): ");
				System.out.print("선택> ");
				input = scanner.nextLine();
				if (input.equalsIgnoreCase("y")) {
					System.out.println("\n  ! 서버 오류 인하여 탈퇴가 이루어지지 않았습니다 !");
					System.out.println("               마이페이지로 돌아갑니다\n");
					run();
					
				} else {
					System.out.println("\n탈퇴를 취소합니다");
					System.out.println("               마이페이지로 이동합니다\n");
					run();	
				}
				break;
//					// 계정 삭제하는 코드 작성
//					int count = dao.deleteCustomer(ReservationApplication.getSession().getId());
//					if (count > 0) {
//						System.out.println("\n            ! 계정을 삭제합니다 !");
//						System.out.println("   계정이 삭제되었습니다. 메인화면으로 돌아갑니다.");
//						// 로그인 페이지(메인페이지)로 이동
//						main.getInstance();
//						main.process();
//						// 시연할때는 삭제하지말기
//					}
//					return;
//				} else {
//					System.out.println("\n탈퇴를 취소합니다");
//					System.out.println("           마이페이지로 이동합니다");
//					run();
//				}
//				break;
			case "5":
				// 로그인 페이지(메인페이지)로 이동
				System.out.println("              * 로그아웃 되었습니다 *");
//			    main.process();
				main.getInstance();
				MenuView.printMenu();
				break;
			default:
				System.out.println("! 잘못된 입력입니다 !");

			}
		}
	}

	private void LoginView() {
		// TODO Auto-generated method stub
		
	}

	public void printReservationList(List<ReservationVO> list) {
		for (ReservationVO vo : list) {
			System.out.println(vo);
		}
	}

}
