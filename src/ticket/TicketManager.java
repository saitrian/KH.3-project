package ticket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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
		case CHECK :
			check();
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

		try {
			System.out.println(ticketList.get(movieNum - 1));
			util.printDottedLine();
			System.out.println("예매를 완료 했습니다.");
			util.printDottedLine();
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
		
		// 영화표 예매 정보로 내역을 검색하기
		
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
		util.scan.nextLine();
		String search = util.scan.nextLine();
		
		// 영화 상영작 목록에서 검색어가 제목에 들어간 게시글 리스트를 가져옴
		List<Ticket> searchList = getSearchList(search);
		
		// ticketList에 영화가 없으면 종료
		if(ticketList.size() == 0) {
			util.printDottedLine();
			System.err.println("검색된 영화가 없습니다.");
			util.printDottedLine();
			return;
		}
		
		// 현재 searchList에 저장된 상영작 목록 출력
		System.out.println("-----현재 상영작 목록-----");
		for(Ticket post : searchList) {
			System.out.println(post);
		}
		
		util.printDottedLine();

		// 메뉴로 돌아가려면... 문구 출력
		System.err.print("메뉴로 돌아가려면 엔터를 치세요.");
		
		// 엔터를 입력받도록 처리
		util.scan.nextLine(); // 입력한 엔터 처리
	}

	/**
	 * 기능 : 검색어를 입력시 검색어 검색 기능 메소드
	 * @param search 
	 * @return
	 */
	private List<Ticket> getSearchList(String search) {
		List<Ticket> searchList = new ArrayList<Ticket>();
		// 전체 게시글에서 하나씩 꺼내서 전체 탐색
		for(Ticket ticket : ticketList) {
			// 게시글에 제목 또는 내용에 검색어가 포함되어 있으면 검색 리스트에 추가
			if(ticket.getMovieName().contains(search)) {
				searchList.add(ticket);
			}
		}
		return searchList;
	}

	@Override
	public void run() {
		int menu;
		
		//load(fileName);
		
		do {
			printMenu();
			menu = inputNumber("메뉴 : ");
			
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
}
