import java.util.Scanner;

public class MenuView {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.println("\n====================================================");
		System.out.println("⁺ • ˚. *࿐ ⁺ • ˚. *࿐ ⁺ • ˚. *࿐ ⁺ • ˚. *࿐\n\n");
		System.out.println("                   [ 𝑫𝑫 𝑪𝒍𝒆𝒂𝒏 ]");
		System.out.println("                𝑊𝑒𝑙𝑐𝑜𝑚𝑒 𝑡𝑜 𝐷𝐷 𝐶𝑙𝑒𝑎𝑛\n\n");
		System.out.println("                   ➊ 회원 로그인");
		System.out.println("                   ➋ 회원 가입");
		System.out.println("                   ➌ 회사 로그인\n\n"); 
		System.out.println("⁺ • ˚. *࿐ ⁺ • ˚. *࿐ ⁺ • ˚. *࿐ ⁺ • ˚. *࿐ ");
		System.out.println("====================================================");
	}
	
	public static String inputMenu() {
		return scanner.nextLine();
	}
	
	
	public static void printIllegalArgmentMenu(String selected) {
		System.out.println("\n" + selected + "번은 잘못된 선택입니다");
		System.out.println("다시 입력해주세요");
	}
}
