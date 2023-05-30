

import java.util.Scanner;

public class JoinView {
//	public static void main(String[] args) {
//		JoinView jv = new JoinView();
//		jv.joinService();
//	}
	
	private static int result;
	public static Scanner scanner = new Scanner(System.in);
	
	public CustomerVO joinService() {
		CustomerVO vo = new CustomerVO();
		while(true) {
			try {
				System.out.println("\n====================================================\n");
				System.out.println("                    [회원가입]               \n");
				System.out.print("   아이디: ");
				String id = scanner.nextLine();
				if(id.length() < 4 || id.length() > 10) {
					throw new NumberFormatException();
				}
				System.out.print("   비밀번호: ");
				String pw = scanner.nextLine();
				System.out.print("   이름: ");
				String name = scanner.nextLine();
				System.out.print("   전화번호(000-0000-0000): ");
				String telno = scanner.nextLine();
				System.out.print("   이메일: ");
				String email = scanner.nextLine();
				System.out.print("   주소: ");
				String add = scanner.nextLine();
				vo = new CustomerVO(id, pw, name, telno, email, add);
				System.out.println();
				JoinDAO dao = JoinDAO.getInstance();
				dao.JoinService(vo);
				result = 1;
				break;
			} catch (NumberFormatException e) {
				System.out.println("   아이디는 4~10자리만 가능합니다.");
				result = 0;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("   오류가 발생하였습니다.");
				System.out.println("   다시 시도해주세요.");
				result = 0;
			}
		}
		return vo;
	}
		
			

	/**
     * 회원 가입 결과
     * @param Integer.parseInt(selected)
     * @return 회원 가입 성공시 반복문 종료를 위해 false 반환, 실패시 반복을 위한 true 반환
     */
    public boolean resultJoin(String selected, Scanner scanner) {
        if (Integer.parseInt(selected) > 0) {
            System.out.println("         * 회원가입이 완료되었습니다 *");
            System.out.print("          로그인 페이지로 이동합니다.\n\n");
            System.out.println("=====================================================");
            return false;
        }
        System.out.println("             ! 회원가입 실패 !");
        System.out.print("          다시 시도하시겠습니까? (y/n).\n\n");
        System.out.println("====================================================");
        System.out.print("> ");
        String answer = scanner.nextLine();
        if (!"y".equalsIgnoreCase(answer)) {
            // y를 입력하지 않으면 회원가입 종료, 그렇지 않으면 회원가입 다시 시작하기
            return false;
        }
        return true;
        
		}
}
