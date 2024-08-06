package sjk.sample_2.teamProject.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.Util;

import sjk.sample_2.teamProject.controller.MemberController;
import sjk.sample_2.teamProject.controller.MovieController;
import sjk.sample_2.teamProject.controller.TicketController;
// 이거 에러 ...?
import sjk.sample_2.teamProject.database.Database;
import sjk.sample_2.teamProject.important.Program;
import sjk.sample_2.teamProject.important.Utility;
import sjk.sample_2.teamProject.model.tp.NewClass;
import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.Ticket;
import sjk.sample_2.teamProject.model.vo.TicketVO;
import sjk.sample_2.teamProject.service.ScheduleServiceImp;

public class Kiosk implements Program {	
	private final Utility UTIL = Utility.getInstance();	

	private final int TICKETING = 1;
	private final int REFUND = 2;
	private final int CHECK = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;

	private Scanner scan = new Scanner(System.in);

	private MovieController movieController = new MovieController(scan);
	private TicketController ticketController = new TicketController(scan);
	private MemberController memberController = new MemberController(scan);
	private ScheduleServiceImp scheduleServiceImp = new ScheduleServiceImp();

	public Kiosk() {
	}

	@Override
	public void printMenu() {
		UTIL.printDottedLine();
		System.out.print("      << 메뉴 >>    \r\n"
						+"1. 영화 예매(구매)\r\n"
						+"2. 영화표 환불\r\n"
						+"3. 영화표 조회\r\n"
						+"4. 포인트 조회\r\n"
						+"5. 프로그램 종료\r\n");
		UTIL.printDottedLine();
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case TICKETING :
			buyTicket();
			break;
		case REFUND :
			refund();
			break;
		case CHECK :
			check();
			break;
		case SEARCH :
			search();
			break;
		case EXIT :
			UTIL.printDottedLine();
			System.out.println("프로그램을 종료합니다.\r\n"
					+ "이용해주셔서 감사합니다. (～￣▽￣)～");
			UTIL.printDottedLine();
			break;
		default :
			System.err.println("잘못된 번호 입력입니다.");
		}
	}

	private void refund() {
		UTIL.printDottedLine();
		String id = memberController.login();
		if( id == null) {
			return;
		}
		if(scheduleServiceImp.deleteMovieInfo(id)) {
			downPoint(id);
			System.out.println("환불 성공");
			return;
		}
		System.out.println("환불 실패");
		return;
	}


	private void buyTicket() {
		// 현재 상영 목록 출력
		System.out.println("-----현재 상영작 목록-----");
		movieController.getMovieList();
		// 상영 영화 번호 입력 추가 << 
		UTIL.printDottedLine();
		int movieNum = inputNumber("예매할 영화 번호 선택 : ");

		String id;

		for(;;) {
			// 로그인 하고 로그인 성공 시 예매 성공
			id = memberController.login();
			if (!(id == null)) {
				ticketController.insertTicket(id, movieNum);
				UTIL.printDottedLine();
				usePoint(id);
				UTIL.printDottedLine();
				System.out.println("예매를 완료 했습니다.");
				return;
			} else {
				return;
			}
		}
	}
	/**
	 * 기능 : 입력 받은 회원정보(id)와 같은 번지에 있는 포인트 사용 여부 입력받는 메서드
	 * @param inputId 입력 받은 회원정보(id)
	 * */
	private void usePoint(String id) {

		// 잘못된 값 입력 시에 돌아오게 하는 무한루프
		for(;;) {
			// 포인트 사용 메뉴 출력
			System.out.println("포인트 사용 메뉴\r\n"
					+ "1. 포인트 사용\r\n"
					+ "2. 포인트 적립");
			int menu = inputNumber("메뉴 입력 : ");

			// 포인트 사용 선택 시
			if(menu == 1) {
				memberController.usePoint(id);
				System.out.println("포인트 사용 완료!");
				UTIL.printDottedLine();
				return;
			}
			// 포인트 적립 선택 시
			else if(menu == 2) {
				memberController.upPoint(id);
				System.out.println("포인트 적립 완료!");
				UTIL.printDottedLine();
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
	
	private void downPoint(String id) {
		memberController.usePoint(id);
	}
	/**
	 * 기능 : 영화표 조회 기능
	 */
	private void check() {

		printSearchMenu();
		int checkMenu = inputNumber("번호 선택 : ");
		runSearch(checkMenu);
	}



	/**
	 * 기능 : 예매한 정보로 예매 내역을 검색하는 메소드
	 */
	private void checkIdTicketInfo() {
		String id = memberController.login();
		TicketVO ticket =ticketController.selectTicket(id);
		System.out.println(id + "님의 예매 내역");
		System.out.println(ticket);
	}

	/**
	 * 기능 : 조회 기능 메뉴 실행 메소드
	 */
	private void printCheckMenu() {
		UTIL.printDottedLine();
		System.out.print(
				"1. 로그인\n"
						+"2. 뒤로가기\n");
		UTIL.printDottedLine();
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

	private void search() {
		int menu;
		do {
			printCheckMenu();
			menu = inputNumber("메뉴 선택 : ");
			switch(menu) {
			case 1:
				memberController.searchPoint();
				return;
			case 2:
				break;
			default:
				System.err.println("잘못된 번호 입력입니다.");
				break;
			}
		}while(menu != 2);

	}

	private void printSearchMenu() {
		UTIL.printDottedLine();
		System.out.print("메뉴\r\n"
						+"1. 영화 제목으로 검색\r\n"
						+"2. 영화 시간으로 검색\r\n"
						+"3. 아이디로 검색\r\n"
						+"4. 뒤로가기\r\n");
		UTIL.printDottedLine();
	}
	
	private void runSearch(int menu) {
		switch(menu) {
		case 1 :
			PSV();
			break;
		case 2 :
			OJY();
			break;
		case 3 :
			PCW();
			break;
		case 4 :
			return;
		default :
			System.err.println("잘못된 번호 입력입니다.");
		}
	}

	private void PCW() {
		String id = memberController.login();
		if( id == null) {
			return;
		}
		scheduleServiceImp.selectMovieInfo(id);
	}

	private void OJY() {
		// TODO Auto-generated method stub
		
	}

	private void PSV() {
		// TODO Auto-generated method stub
		
	}
}
