package sjk.sample_2.teamProject.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import sjk.sample_2.teamProject.controller.MemberController;
import sjk.sample_2.teamProject.controller.MovieController;
import sjk.sample_2.teamProject.controller.TicketController;
// 이거 에러 ...?
import sjk.sample_2.teamProject.database.Database;
import sjk.sample_2.teamProject.important.Program;
import sjk.sample_2.teamProject.important.Utility;
import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.Ticket;

public class Kiosk implements Program {	
	private final Utility UTIL = Utility.getInstance();	

	private final int TICKETING = 1;
	private final int REFUND = 2;
	private final int CHECK = 3;
	private final int PRODUCE = 4;
	private final int EXIT = 5;
	
	private Scanner scan = new Scanner(System.in);
	
	private MovieController movieController = new MovieController(scan);
	private TicketController ticketController = new TicketController(scan);
	private MemberController memberController = new MemberController(scan);
	
	public Kiosk() {
	}

	@Override
	public void printMenu() {
		System.out.print(
				"메뉴\r\n"
						+"1. 영화 예매(구매)\r\n"
						+"2. 영화표 환불(미구현)\r\n"
						+"3. 영화표 조회\r\n"
						+"4. 영화 검색\r\n"
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
		// 현재 상영 목록 출력
		System.out.println("-----현재 상영작 목록-----");
		movieController.getMovieList();
		
		// 로그인 하고 로그인 성공 시 예매 성공
		String id = memberController.login();
		if (id == null) {
			return;
		}
		// 상영 영화 번호 입력 추가 << 
		UTIL.printDottedLine();
		int movieNum = inputNumber("예매할 영화 번호 선택 : ");
		
		ticketController.insertTicket(id, movieNum);		
	}

	/**
	 * 기능 : 입력 받은 회원정보(id)와 같은 번지에 있는 포인트 사용 여부 입력받는 메서드
	 * @param inputId 입력 받은 회원정보(id)
	 * */
	private void usePoint(String inputId) {
		
		
		
	}

	/** 
	 * 기능 : 입력 받은 회원정보(id)와 같은 번지에 있는 포인트 증가시키기
	 * @param inputId 입력 받은 회원정보(id)
	 * */	
	private void changePoint(String inputId, int point) {
	}
	
	@SuppressWarnings("unused")
	private void changePoint(String inputId, boolean isInc) {
	}

	/**
	 * 기능 : 영화표 조회 기능
	 */
	private void check() {
		
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
	}

	/**
	 * 기능 : 검색어를 입력시 검색어 검색 기능 메소드
	 * @param search 
	 * @return
	 */
	private List<Ticket> getSearchList(String search) {
		List<Ticket> searchList = new ArrayList<Ticket>();
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
		return 0;
	}
}
