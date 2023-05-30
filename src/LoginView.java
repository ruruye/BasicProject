
import java.util.Scanner;

public class LoginView {
	

	public CustomerVO inputCustomerVO(Scanner scanner) {
		System.out.println("\n====================================================\n");
		System.out.println("                    [ 𝑳𝒐𝒈𝒊𝒏 ]\n");
		System.out.print("                 ID : ");
		String id = scanner.nextLine();
		System.out.print("                 Password : ");
		String pw = scanner.nextLine();
		return new CustomerVO(id, pw);
		
	}

	public void printLoginResult(CustomerVO vo, boolean type) {
		// 로그인서비스(LoginServie를 통해 전달된 VO객체가 존재하면 로그인 성공 출력
		if (vo != null) {
			System.out.println("\n             * 로그인에 성공하였습니다 *");
			System.out.println("              " + (type ? "마이" : "관리자") + "페이지로 이동합니다");
			System.out.println("\n====================================================\n");
			// 로그인 성공시 어디서든지 접근 가능한 session이라는 변수에 VO정보 저장
			ReservationApplication.setSession(vo);
		} else {
			System.out.println("\n                   ! 로그인 실패 !");
			System.out.println("      아이디 또는 비밀번호가 올바르지 않습니다");
			System.out.println("         입력하신 내용을 다시 확인해주세요");
			System.out.println("\n====================================================\n");
		}
	}
	public CompanyVO inputCompanyVO(Scanner scanner) {
		System.out.println("\n====================================================\n");
		System.out.println("                      [ 𝑳𝒐𝒈𝒊𝒏 ]\n");
		System.out.print("                 ID : ");
		String id = scanner.nextLine();
		System.out.print("                 Password : ");
		String pw = scanner.nextLine();
		return new CompanyVO(id, pw);
	}

}
