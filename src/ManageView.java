

import java.util.List;
import java.util.Scanner;

public class ManageView {

	private static ManageView instance = new ManageView();
	private ReservationApplication main = ReservationApplication.getInstance();

	public static ManageView geInstance() {
		if (instance == null) {
			instance = new ManageView();
		}
		return instance;
	}
	
	public void showMenu() {
		CustomerVO vo = ReservationApplication.getSession();
		System.out.println("====================================================\n");
		System.out.println("                  [ 관리자 페이지 ] \n");
		System.out.println("                  회사: "  + vo.getName()+"\n");
		System.out.println("                  ➊ 예약내역 ");
		System.out.println("                  ➋ 직원내역 ");
		System.out.println("                  ➌ 로그아웃 \n");
		System.out.println("====================================================");
	}

	public void run() throws Exception {
		Scanner scanner = new Scanner(System.in);
		ManageDAO dao = new ManageDAO();
		ReservationApplication reservationApplication = new ReservationApplication();

		while (true) {
			showMenu();
			System.out.print("선택> ");
			String input = scanner.nextLine();

			switch (input) {
			case "1": 
				System.out.println("\n===================================================\n");
				System.out.println("	 	     [예약내역]\n");
				List<ReservationsVO> list = dao.getReservationList(ReservationApplication.getSession().getId());
				printReservationList(list);
				System.out.println("\n====================================================\n");
				System.out.println("관리자 페이지로 돌아가려면 [0]을 입력하시오.");
				System.out.print("선택> ");
				input = scanner.nextLine();
				System.out.println(); 
				if(input.equals("0")) {
					run();
				}
				
				break;
			case "2":
				System.out.println("\n====================================================\n");
				System.out.println("  		     [직원내역]\n");
				List<EmployeeVO> employeeList = dao.getEmployeeList(ReservationApplication.getSession().getId());
				printEmployeeList(employeeList);
				System.out.println("\n====================================================\n");
				System.out.println("관리자 페이지로 돌아가려면 [0]을 입력하시오.");
				System.out.print("선택> ");
				input = scanner.nextLine();
				System.out.println();
				if(input.equals("0")) {
					run();
				}
				break;
			case "3":
				System.out.println("\n               * 로그아웃 되었습니다 *");
				System.out.println("               메인화면으로 돌아갑니다\n");	
				// 로그인창 메소드 호출
				reservationApplication.process();
				break;
				// 만약 메인페이지로 가야한다면
				//main.process();
				// 만약 그대로 종료하고 싶다면 아래 코드 활성화
//				System.exit(0);
			}
		}
	}
	public void printReservationList(List<ReservationsVO> list) {
		for (ReservationsVO vo : list) {
			System.out.println(vo);
		}
	}
	public void printEmployeeList(List<EmployeeVO> list) {
		for (EmployeeVO vo : list) {
			System.out.println(vo);
		}
	}
}
