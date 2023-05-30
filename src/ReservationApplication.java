
import java.util.Scanner;

public class ReservationApplication {
	private static ReservationApplication instance = new ReservationApplication();
	
	public ReservationApplication() {
	}
	
	public static ReservationApplication getInstance() {
		return instance;
	}
	private static CustomerVO session = new CustomerVO();
	private static final Scanner scanner = new Scanner(System.in);
	LoginView lview = new LoginView();
	LoginController controller = new LoginController();
	private ManageView manageView = new ManageView();
	private MypageView mypageView = new MypageView();

	public static void main(String[] args) throws Exception {
		ReservationApplication.getInstance().process();
	}

	public void process() throws Exception {
		JoinView joinView = new JoinView();
		MenuView.printMenu();
		// 메뉴 출력
		while (true) {
			System.out.print("선택> ");
			String selected = MenuView.inputMenu();
			// 선택된 메뉴
			switch (selected) {
			case "1":
				controller.login(scanner, true);
				mypageView.run();
				break;
			case "2":
				joinView.joinService();
				boolean flag = joinView.resultJoin(selected, scanner);
				if (!flag) {
					controller.login(scanner, true);
					mypageView.run();
					break;
				} else {
					process();
				}
				// 2. XXX 호출
				break;
			case "3":
				controller.login(scanner, false);
				manageView.run();
				break;
			default:
				MenuView.printIllegalArgmentMenu(selected);
			}
		}
	}
	
	public static CustomerVO getSession() {
		return session;
	}

	public static void setSession(CustomerVO session) {
		ReservationApplication.session = session;
	}
	

}
