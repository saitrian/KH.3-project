package teamProject.ticket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import teamProject.database.Database;
import teamProject.important.Program;
import teamProject.important.Utility;
import teamProject.user.User;

public class TicketManager implements Program {	
	private final Utility UTIL = Utility.getInstance();
	private final Database DB = Database.getInstance();
	private List<Integer> checkUserTicketList = new ArrayList<Integer>();

	private final int TICKETING = 1;
	private final int REFUND = 2;
	private final int CHECK = 3;
	private final int PRODUCE = 4;
	private final int EXIT = 5;

	public TicketManager() {
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
		case CHECK :
			check();
			break;
		default :
			System.err.println("잘못된 번호 입력입니다.");
		}		
	}

	private void buyTicket() {
		if(DB.getTicketList().size() == 0 ) {
			System.err.println("현재 상영작이 없습니다.");
			return;
		}

		System.out.println("-----현재 상영작 목록-----");
		System.out.println(DB.getTicketListStr());

		UTIL.printDottedLine();
		int movieNum = inputNumber("예매할 영화 번호 선택 : ");
		// loginCheck() 메소드 리턴 값을 checkNum에 받기
		// checkNum 값이 0(아이디, 패스워드 불일치)이면...
		for(;;) {
			int checkNum = loginCheck();
			if(checkNum == 1) {
				checkUserTicketList.add(movieNum);
				break;
			}
			printRepeatMenu();
			int loginMenu = inputNumber("메뉴 선택 : ");
			if(loginMenu == 2) {
				return;
			}
			else if(loginMenu != 1) {
				System.out.println("잘못된 번호 입력입니다.");
				return;
			}
		}
		// 로그인 성공 ( 아이디, 패스워드 일치) 시 예매 그대로 완료

		try {
			System.out.println(DB.getTicketList().get(movieNum - 1));
			UTIL.printDottedLine();
			System.out.println("예매를 완료 했습니다.");
			UTIL.printDottedLine();
		} catch(IndexOutOfBoundsException e) {
			System.err.println("잘못된 값을 선택하셨습니다.");
		}
	}
	
	/**
	 * 기능 : 영화표 조회 기능
	 */
	private void check() {
		/*
		 * TODO 예매 정보를 가지고 있기
		 *			- 예매 정보 검색
		 *			- 영화 이름으로 검색 (완)
		 */
		
		printCheckMenu();
		
		int checkMenu = inputNumber("번호 선택 : ");
		
		runCheckMenu(checkMenu);
		
	}

	/**
	 * 기능 : 받은 checkMenu로 메뉴 선택하는 메소드
	 * @param checkMenu 받은 메뉴 값
	 */
	private void runCheckMenu(int checkMenu) {
		switch(checkMenu) {
		case 1 :
			checkTicketNumInfo();
			break;
		case 2 :
			checkTicketList();
			break;
		default :
			System.err.println("잘못된 번호 입력입니다.");
		}	
	}

	/**
	 * 기능 : 예매한 정보로 예매 내역을 검색하는 메소드
	 */
	private void checkTicketNumInfo() {
		// 영화표 예매 정보를 가지고 있기
		for(;;) {
			int checkNum = loginCheck();
			if(checkNum == 1) {
				break;
			}
			printRepeatMenu();
			int loginMenu = inputNumber("메뉴 선택 : ");
			if(loginMenu == 2) {
				return;
			}
			else if(loginMenu != 1) {
				System.out.println("잘못된 번호 입력입니다.");
				return;
			}
		}
		// 영화표 예매 정보로 내역을 검색하기
		
		
		if(checkUserTicketList.size() == 0) {
			System.err.println("검색된 예매 내역이 없습니다.");
			return;
		}
		System.out.println(DB.getUserListStr());
		
	}

	/**
	 * 기능 : 조회 기능 메뉴 실행 메소드
	 */
	private void printCheckMenu() {
		System.out.print(
				 "1. 예매 정보 검색\n"
				+"2. 영화 이름으로 검색\n");
	}

	/**
	 * 기능 : 영화 이름 검색 메소드
	 */
	private void checkTicketList() {
		// 검색할 영화 입력
		System.out.print("검색할 영화 제목 입력(전체 검색은 엔터) : ");
		UTIL.scan.nextLine();
		String search = UTIL.scan.nextLine();
		
		// 영화 상영작 목록에서 검색어가 제목에 들어간 게시글 리스트를 가져옴
		List<Ticket> searchList = getSearchList(search);
		
		// ticketList에 영화가 없으면 종료
		if(DB.getTicketList().size() == 0) {
			UTIL.printDottedLine();
			System.err.println("검색된 영화가 없습니다.");
			UTIL.printDottedLine();
			return;
		}
		
		// 현재 searchList에 저장된 상영작 목록 출력
		System.out.println("-----현재 상영작 목록-----");
		for(Ticket post : searchList) {
			System.out.println(post);
		}
		
		UTIL.printDottedLine();

		// 메뉴로 돌아가려면... 문구 출력
		System.err.print("메뉴로 돌아가려면 엔터를 치세요.");
		
		// 엔터를 입력받도록 처리
		UTIL.scan.nextLine(); // 입력한 엔터 처리
	}

	/**
	 * 기능 : 검색어를 입력시 검색어 검색 기능 메소드
	 * @param search 
	 * @return
	 */
	private List<Ticket> getSearchList(String search) {
		List<Ticket> searchList = new ArrayList<Ticket>();
		// 전체 게시글에서 하나씩 꺼내서 전체 탐색
		for(Ticket ticket : DB.getTicketList()) {
			// 게시글에 제목 또는 내용에 검색어가 포함되어 있으면 검색 리스트에 추가
			if(ticket.getMovieName().contains(search)) {
				searchList.add(ticket);
			}
		}
		return searchList;
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
			return UTIL.scan.nextInt();
		} catch(InputMismatchException e) {
			UTIL.scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에서 비워줌.
			return Integer.MIN_VALUE; // int의 가장 작은 수를 리턴
		}
	}

	public int loginCheck() {
		// 아이디 비밀번호 입력받기
		System.out.print("아이디를 입력하세요 : ");
		String inputId = UTIL.scan.next();
		UTIL.scan.nextLine(); // 공백처리

		System.out.print("비밀번호를 입력하세요 : ");
		String inputPassword = UTIL.scan.next();
		UTIL.scan.nextLine(); // 공백처리

		// 반복문 실행 (입력한 아이디와 비밀번호 일치하는지 확인용)
		for( int i = 0 ; i < DB.getUserList().size() ; i ++ ) {
			// 입력한 아이디와 비밀번호 일치하면 '로그인 성공!' 출력 후 정수 1리턴
			if(inputId.equals(DB.getUserList().get(i).getName())&&inputPassword.equals(DB.getUserList().get(i).getPassword())) {
				UTIL.printDottedLine();
				System.out.println("로그인 성공!");
				UTIL.printDottedLine();
				return 1;
			}
		}
		// 입력한 아이디와 비밀번호 일치하지 않으면 '로그인 실패...' 출력 후 0 리턴
		UTIL.printDottedLine();
		System.out.println("로그인 실패...");
		UTIL.printDottedLine();
		return 0;
	}
}
