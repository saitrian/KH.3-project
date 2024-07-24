package ticket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import important.Program;
import important.Utility;
import user.User;
//Program 클래스의 메서드들을 구현
public class TicketManager implements Program {
	// 직관적으로 알기 쉽게 상수를 지정
	private final int TICKETING = 1;
	private final int REFUND = 2;
	private final int CHECK = 3;
	private final int EXIT = 4;
	
	//Utility 안의 메서드들를 사용하기 위해 호출
	private Utility util = Utility.getInstance();
	//ticketList 리스트 생성
	private List<Ticket> ticketList = new ArrayList<Ticket>();
	//userList 리스트 생성
	private List<User> userList = new ArrayList<User>();
	//리스트에 추가할 객체들을 만든 뒤 각각 ticketList, userList에 추가 
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
	//메뉴를 출력
	public void printMenu() {
		System.out.print(
					"메뉴\r\n"
					+"1. 영화 예매(구매)\r\n"
					+"2. 영화표 환불\r\n"
					+"3. 영화표 조회\r\n"
					+"4. 프로그램 종료\r\n");
	}

	@Override
	//메뉴를 동작시키기 위한 메서드
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		//TICKETING에 대한 값이 주어지면 buyTicket 메서드 실행
		case TICKETING :
			buyTicket();
			break;
		case REFUND:
			break;
		case CHECK:
		default :
			//지정된 값이 아닐 시 잘못된 번호 입력입니다. 출력
			System.err.println("잘못된 번호 입력입니다.");
		}		
	}

	private void buyTicket() {
		//만약 ticketList의 크기가 0이라면(비어있다면) 현재 상영작이 없습니다. 츨략 흐 리턴
		if(ticketList.size() == 0) {
			System.err.println("현재 상영작이 없습니다.");
			return;
		}
		
		System.out.println("-----현재 상영작 목록-----");
		int i = 0;
		//i가 ticketList의 크기만큼 계속 증가하고 증가할 떄 마다 i와 같은 번지의 객체를 출력
		for(Ticket tmp : ticketList) {
			i++;
											 //i번지의 객체 중 관을 불러오기 / i번지의 객체 중 영화이름 불러오기 / i번지의 객체 중 날짜 불러오기
			System.out.println(i + ". 상영관 " + tmp.getTheater() + "관 / "+ tmp.getMovieName() + " / 날짜 : " + tmp.getDate());
		}
		//절취선
		util.printDottedLine();
		//예매할 영화 번호의 값을 입력받기
		int movieNum = inputNumber("예매할 영화 번호 선택 : ");

		try {
			//번지는 0번지부터 시작이기 때문에 입력받은 값에 -1 
			System.out.println(ticketList.get(movieNum - 1));
			util.printDottedLine();
			System.out.println("예매를 완료 했습니다.");
			util.printDottedLine();
		} catch(IndexOutOfBoundsException e) {
			System.err.println("잘못된 값을 선택하셨습니다.");
		}
	}

	@Override
	public void run() {
		int menu;
		
		//load(fileName);
		
		do {
			//printMenu()를 호출 후 값을 입력받기
			printMenu();
			menu = inputNumber("메뉴 : ");
			
			try {
				runMenu(menu);
				//잘못된 값을 받을 시 예외 발생
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
