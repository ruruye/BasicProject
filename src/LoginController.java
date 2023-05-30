
import java.util.Scanner;

public class LoginController {
	private final LoginService loginService = new LoginService();
	private LoginView view = new LoginView();

	public void login(Scanner scanner, boolean type) throws Exception {
		CustomerVO vo = null;
		while (true) {
			// 화면에 아이디와 비밀번호 입력하는 메소드
			if (type) {
				vo = view.inputCustomerVO(scanner);
			} else {
				vo = view.inputCompanyVO(scanner);
			}
			CustomerVO customer = loginService.login(vo, type);
			view.printLoginResult(customer, type);
			// vo가 null이면 로그인 정보를 다시 입력하기 위해 반복문 실행
			if (customer != null) {
				break;
			}
		}
	}
	
}