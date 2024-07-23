package ticket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import important.Program;
import important.Utility;
import user.User;

public class TicketManager implements Program {

	private final int TICKETING = 1;
	private final int REFUND = 2;
	private final int CHECK = 3;
	private final int PRODUCE = 4;
	private final int EXIT = 5;

	private Utility util = Utility.getInstance();
	private List<Ticket> ticketList = new ArrayList<Ticket>();
	private List<User> userList = new ArrayList<User>();


	public TicketManager() {
		ticketList.add(new Ticket("탈주", "1" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("탈주", "2" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("탈주", "3" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("어벤져스", "4" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("어벤져스", "5" , "2024-07-01 12:00"));

		userList.add(new User("aaa", "111"));
		userList.add(new User("bbb", "222"));
	}

	@Override
	public void printMenu() {
		System.out.print(
				"메뉴\r\n"
						+"1. 영화 예매(구매)\r\n"
						+"2. 영화표 환불\r\n"
						+"3. 영화표 조회\r\n"
						+"4. 프로그램 종료\r\n");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case TICKETING :
			buyTicket();
			break;
		default :
			System.err.println("잘못된 번호 입력입니다.");
		}		
	}

	private void buyTicket() {
		if(ticketList.size() == 0) {
			System.err.println("현재 상영작이 없습니다.");
			return;
		}

		System.out.println("-----현재 상영작 목록-----");
		int i = 0;
		for(Ticket tmp : ticketList) {
			i++;
			System.out.println(i + ". 상영관 " + tmp.getTheater() + "관 / "+ tmp.getMovieName() + " / 날짜 : " + tmp.getDate());
		}

		util.printDottedLine();
		int movieNum = inputNumber("예매할 영화 번호 선택 : ");
		// loginCheck() 메소드 리턴 값을 checkNum에 받기
		int checkNum = loginCheck();
		// checkNum 값이 0(아이디, 패스워드 불일치)이면...
		if(checkNum == 0) {
			// 로그인 실패 시 로그인 재시도 or 메인 메뉴로 돌아갈지 선택하는 메뉴 
			int menu = 0;
			do {
				// 로그인 여부 선택하는 메뉴 출력하는 메소드
				printRepeatMenu();
				menu = inputNumber("메뉴 선택 : ");
				util.scan.nextLine();
				switch(menu) {
				case 1 :
					// 로그인 재시도 선택 시 buyTicket() 초기화면으로
					// Q1. 예매할 영화 번호 선택 다시 안받고, 로그인만 바로 시도할 수 있게 하는 방법???
					// Q2. 공백처리가 이상한지 처음만 잘 실행됩니다...
					//	- 중간에 고쳐지긴 하는데??
					// Q3. 중간에 로그인 하는 부분만 메소드화 하고 싶은데 잘 모르겠어요...
					util.printDottedLine();
					buyTicket();
					break;
				case 2 :
					// return 입력해서 다시 메인 메뉴로
					util.printDottedLine();
					return;
				default :
					break;
				}
			}while(menu != 2);
		}
		// 로그인 성공 ( 아이디, 패스워드 일치) 시 예매 그대로 완료
		try {
			System.out.println(ticketList.get(movieNum - 1));
			util.printDottedLine();
			System.out.println("예매를 완료 했습니다.");
			util.printDottedLine();
		} catch(IndexOutOfBoundsException e) {
			System.err.println("잘못된 값을 선택하셨습니다.");
		}
	}

	private void printRepeatMenu() {
		System.out.println(
				"메뉴\r\n"
				+ "1. 로그인 재시도\r\n"
				+ "2. 메인 메뉴로\r\n");
	}

	@Override
	public void run() {
		int menu;
		//load(fileName);
		do {
			printMenu();
			menu = inputNumber("메뉴 선택 : ");

			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}while(menu != EXIT);
	}

	public int inputNumber(String menuName) {
		try {
			System.out.print(menuName);
			return util.scan.nextInt();
		} catch(InputMismatchException e) {
			util.scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에서 비워줌.
			return Integer.MIN_VALUE; // int의 가장 작은 수를 리턴
		}
	}

	public int loginCheck() {
		// 아이디 비밀번호 입력받기
		System.out.print("아이디를 입력하세요 : ");
		String inputId = util.scan.next();
		util.scan.nextLine();
		
		System.out.print("비밀번호를 입력하세요 : ");
		String inputPassword = util.scan.next();
		util.scan.nextLine();
		// 반복문 실행 (입력한 아이디와 비밀번호 일치하는지 확인용)
		for( int i = 0 ; i < userList.size() ; i ++ ) {
			// 입력한 아이디와 비밀번호 일치하면 '로그인 성공!' 출력 후 정수 1리턴
			if(inputId.equals(userList.get(i).getName())&&inputPassword.equals(userList.get(i).getPassword())) {
				util.printDottedLine();
				System.out.println("로그인 성공!");
				util.printDottedLine();
				return 1;
			}
		}
		// 입력한 아이디와 비밀번호 일치하지 않으면 '로그인 실패...' 출력 후 0 리턴
		util.printDottedLine();
		System.out.println("로그인 실패...");
		util.printDottedLine();
		return 0;
	}
}