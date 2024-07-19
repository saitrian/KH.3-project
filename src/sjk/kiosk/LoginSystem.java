package sjk;

import java.util.Scanner;

public class LoginSystem {
	private Scanner scan = new Scanner(System.in);
	
	private UserList userList;
	
	public LoginSystem(UserList userList) {
		this.userList = userList;
	}
	
	public void printMenu() {
		System.out.println("--- L O G I N ---");
		System.out.println("1. 회원 로그인");
		System.out.println("2. 비회원 로그인");
		System.out.println("3. 나가기");
	}
	
	public String confirmLogin() {
		String id = "", pw;
		boolean isPass = false;
		
		while (isPass == false) {
			printMenu();
			
			switch (scan.nextInt()) {
			case 1:	
				id = inputID();

				pw = inputPassword();
				
				if (userList.contain(id, pw) == false)
					break;
				
				isPass = true;
				break;
			case 2:
				id = "temp_" + (int)(Math.random() * 100 + 1);
				System.out.println("비회원 아이디 : " + id);
				isPass = true;
				break;
			case 3:
				return "";
			default:
				break;
			}
		}
		
		return id;
	}
	
	public boolean checkPassword(String id) {
		String pw = inputPassword();
		
		return userList.contain(id, pw);
	}
	
	public String inputID() {
		System.out.println("ID : ");
		return scan.next();
	}
	
	public String inputPassword() {
		System.out.println("PASSWORD : ");
		return scan.next();
	}
}
