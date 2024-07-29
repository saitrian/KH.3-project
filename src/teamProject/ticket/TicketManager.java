package teamProject.ticket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

// 이거 에러 ...?
//import lombok.launch.PatchFixesHider.Util;
import sjk.kiosk.UserList;
import teamProject.database.Database;
import teamProject.important.Program;
import teamProject.important.Utility;
import teamProject.user.User;

public class TicketManager implements Program {	
	private final Utility UTIL = Utility.getInstance();
	private final Database DB = Database.getInstance();

	private final int TICKETING = 1;
	private final int REFUND = 2;
	private final int CHECK = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	// ----- 2024.07.25 박수빈 추가 -----
	private List<UserTicketCheck> userTicketCheckList = new ArrayList<UserTicketCheck>();
	// ----- 2024.07.25 박수빈 추가 -----
	private List<Integer> tmp_ticketNumber = new ArrayList<Integer>();
	private List<String> tmp_nonMember = new ArrayList<String>();
	
	private final int TICKETNUMBER_1 = 0001;
	private final int TICKETNUMBER_2 = 0002;
	private final int TICKETNUMBER_3 = 0003;
	private final int TICKETNUMBER_4 = 0004;
	private final int TICKETNUMBER_5 = 0005;
	private final String NONMEMBER_1 = "#0001#";
	private final String NONMEMBER_2 = "#0002#";
	private final String NONMEMBER_3 = "#0003#";
	private final String NONMEMBER_4 = "#0004#";
	private final String NONMEMBER_5 = "#0005#";

	public TicketManager() {
		tmp_ticketNumber.add(TICKETNUMBER_1);
		tmp_ticketNumber.add(TICKETNUMBER_2);
		tmp_ticketNumber.add(TICKETNUMBER_3);
		tmp_ticketNumber.add(TICKETNUMBER_4);
		tmp_ticketNumber.add(TICKETNUMBER_5);
		tmp_nonMember.add(NONMEMBER_1);
		tmp_nonMember.add(NONMEMBER_2);
		tmp_nonMember.add(NONMEMBER_3);
		tmp_nonMember.add(NONMEMBER_4);
		tmp_nonMember.add(NONMEMBER_5);
	}

	@Override
	public void printMenu() {
		System.out.print(
				"🎞메뉴\r\n"
						+"1. 영화 예매(구매)\r\n"
						+"2. 영화표 환불(미구현)\r\n"
						+"3. 영화표 조회\r\n"
						+"4. 영화 검색\r\n"
						+"5. 프로그램 종료\r\n");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case TICKETING :
			buyTicket();
			break;
		case CHECK :
			check();
		case SEARCH :
			searchMovie();
			break;
		default :
			System.err.println("잘못된 번호 입력입니다.");
		}		
	}
	//영화 검색 메뉴
	private void searchMovie() {
		printSearchMovieMenu();
		int searchMovieNum = inputNumber("번호 선택 : ");
		switch(searchMovieNum) {
		case 1:
			searchMovieName();
			break;
		case 2:
			searchMovieDate();
			break;
		case 3:
			searchMovieGenre();
			break;
		case 4: 
			prev();
			break;
		default :
			System.err.println("잘못된 번호 입력입니다.");
		}
	}
	
	private void printSearchMovieMenu() {
		System.out.println(
				"---------영화 검색---------\r\n"
						+"----🔍영화 검색 방법 선택----\r\n"
						+"1. 영화 이름으로 검색\r\n"
						+"2. 영화 상영일로 검색\r\n"
						+"3. 영화 장르로 검색\r\n"
						+"4. 이전 메뉴로");
	}
	
	private void searchMovieName() {
		boolean found = false;
		UTIL.printDottedLine();
		System.out.print("검색하실 영화의 이름을 입력하세요 : ");
		UTIL.scan.nextLine();
		String insertSearchMovieName = UTIL.scan.nextLine();
		for(Ticket ticket : DB.getTicketList()) {
			if(ticket.getMovieName().contains(insertSearchMovieName)) {
				found = true;
				System.out.println(ticket.toString());
			}
		}
		if(!found) {
			System.out.println("\"" + insertSearchMovieName + "\"의 검색 결과가 존재하지 않습니다.");
		}
	}

	private void searchMovieDate() {
		boolean found = false;
		UTIL.printDottedLine();
		System.out.print("검색하실 영화의 상영일을 입력하세요 : ");
		UTIL.scan.nextLine();
		String insertSearchMovieDate = UTIL.scan.nextLine();
		for(Ticket ticket : DB.getTicketList()) {
			if(ticket.getDate().contains(insertSearchMovieDate)) {
				System.out.println(ticket.toString());
			}
		}
		if(!found) {
			System.out.println("\"" + insertSearchMovieDate + "\"의 검색 결과가 존재하지 않습니다.");
		}
	}

	private void searchMovieGenre() {
		boolean found = false;
		UTIL.printDottedLine();
		System.out.print("검색하실 영화의 장르를 입력하세요 : ");
		UTIL.scan.nextLine();
		String insertSearchMovieGenre = UTIL.scan.nextLine();
		for(Ticket ticket : DB.getTicketList()) {
			if(ticket.getGenre().contains(insertSearchMovieGenre)) {
				System.out.println(ticket.toString());
			}
		}
		if(!found) {
			System.out.println("\"" + insertSearchMovieGenre + "\"의 검색 결과가 존재하지 않습니다.");
		}
	}

	private void prev() {
		UTIL.printDottedLine();
		System.out.println("이전 메뉴로 돌아갑니다.");
		UTIL.printDottedLine();
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
		String inputId;
		
		for(;;) {
			//아이디 비밀번호 입력받기  
			System.out.print("아이디를 입력하세요 : ");
			inputId = UTIL.scan.next();
			System.out.print("비밀번호를 입력하세요 : ");
			String inputPassword = UTIL.scan.next();
			
			// loginCheck()입력받은 매개변수 id, password 입력하고 checkNum 리턴 받기
			int checkNum = loginCheck(inputId, inputPassword);
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
		// 로그인 성공 ( 아이디, 패스워드 일치) 시 예매 그대로 완료
		// 포인트 사용 여부 선택하는 메서드
		usePoint(inputId);
		try {
			System.out.println(DB.getTicketList().get(movieNum - 1));
			UTIL.printDottedLine();
			System.out.println("예매를 완료 했습니다.");
			// ----- 2024.07.25 박수빈 추가 -----
			UserTicketCheck userTicketChecking = new UserTicketCheck(inputId, movieNum);
			userTicketCheckList.add(userTicketChecking);
			// ----- 2024.07.25 박수빈 추가 -----
			UTIL.printDottedLine();
		} catch(IndexOutOfBoundsException e) {
			System.err.println("잘못된 값을 선택하셨습니다.");
		}
	}

	/**
	 * 기능 : 입력 받은 회원정보(id)와 같은 번지에 있는 포인트 사용 여부 입력받는 메서드
	 * @param inputId 입력 받은 회원정보(id)
	 * */
	private void usePoint(String inputId) {
		// 잘못된 값 입력 시에 돌아오게 하는 무한루프
		for(;;) {
			// 포인트 사용 메뉴 출력
			System.out.println("포인트 사용 메뉴\r\n"
					+ "1. 포인트 사용\r\n"
					+ "2. 포인트 적립");
			int menu = inputNumber("메뉴 입력 : ");
			
			// 포인트 사용 선택 시
			if(menu == 1) {
				// 반복문 사용해서 입력받은 아이디와 같은 번지에 있는 포인트 확인
				for( int i = 0 ; i < DB.getUserList().size() ; i++ ) {
					if( inputId.equals(DB.getUserList().get(i).getName())) {
						// 가지고 있는 포인트가 0 이면
						if(DB.getUserList().get(i).getPoint() == 0 ) {
							// 포인트 없다고 출력 후 upPoint 실행 후 리턴
							UTIL.printDottedLine();
							System.out.println("가지고 있는 포인트가 없습니다.");
							changePoint(inputId, 1);
							return;
						}
					}
				}
				// 가지고 있는 포인트가 0 이 아니면 downPoint 실행 후 리턴 
				changePoint(inputId, -1);
				return;
			}
			// 포인트 적립 선택 시
			else if(menu == 2) {
				// upPoint 실행 후 리턴
				changePoint(inputId, 1);
				return;
			}
			// 다른 번호 선택 시
			else {
				// 잘못된 번호 입력입니다. 출력 후 리턴 없이 다시 위로 보냄
				UTIL.printDottedLine();
				System.out.println("잘못된 번호 입력입니다.");
				UTIL.printDottedLine();
			}
		}
	}

	/** 
	 * 기능 : 입력 받은 회원정보(id)와 같은 번지에 있는 포인트 증가시키기
	 * @param inputId 입력 받은 회원정보(id)
	 * */	
	private void changePoint(String inputId, int point) {
		int checkPoint = 0;
		// 반복문 사용해서 입력받은 아이디와 같은 번지에 있는 포인트 확인
		for( int i = 0 ; i < DB.getUserList().size() ; i++ ) {
			if( inputId.equals(DB.getUserList().get(i).getName())) {
				// 포인트 증가 시키고
				DB.getUserList().get(i).changePoint(DB.getUserList().get(i).getPoint() + point );
				// 보유 중인 포인트 확인 시켜주기 위한 checkPoint 값 입력
				checkPoint = DB.getUserList().get(i).getPoint();
			}
		}
		// 포인트 적립 성공했다고 출력 후 아이디와 함께 보유 중인 포인트 출력
		UTIL.printDottedLine();
		System.out.println("'1' 포인트 적립하셨습니다.\r\n"
				+ inputId + "님의 보유 중인 포인트 : " + checkPoint );
		UTIL.printDottedLine();
	}
	
	@SuppressWarnings("unused")
	private void changePoint(String inputId, boolean isInc) {
		if (isInc == true) {
			changePoint(inputId, 1);
		}
		else {
			changePoint(inputId, -1);
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
		// 영화표 예매 정보를 가지고 와서 예매 내역 검색
		try {
			int i = 0;
			System.out.println("-----예매 내역 리스트-----");
			for(UserTicketCheck tmp : userTicketCheckList) {
				System.out.println((i + 1) + ". " + "예매자 : " + tmp.getUserId() + ", 예매 내역 : " + DB.getTicketList().get(tmp.getTicketCheckNum() - 1).toString());
				i++;
			}
			UTIL.printDottedLine();
		}catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("예외 발생!");
			return;
		}
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

	public int loginCheck(String inputId, String inputPassword) {		
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

class UserTicketCheck{
	String userId;
	int ticketCheckNum;
	
	public UserTicketCheck(String userId, int ticketCheckNum) {
		this.userId = userId;
		this.ticketCheckNum = ticketCheckNum;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public int getTicketCheckNum() {
		return ticketCheckNum;
	}
}
