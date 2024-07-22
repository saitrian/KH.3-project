package teamProject.ticket;

import java.util.InputMismatchException;

import teamProject.database.Database;
import teamProject.important.Program;
import teamProject.important.Utility;

public class TicketManager implements Program {
	
	private final int TICKETING = 1;
	private final int REFUND = 2;
	private final int CHECK = 3;
	private final int PRODUCE = 4;
	private final int EXIT = 5;
	
	private final Utility UTIL = Utility.getInstance();
	private final Database DB = Database.getInstance();
	
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
		default :
			System.err.println("잘못된 번호 입력입니다.");
		}		
	}

	private void buyTicket() {
		if(DB.getTickListSize() == 0) {
			System.err.println("현재 상영작이 없습니다.");
			return;
		}
		
		System.out.println("-----현재 상영작 목록-----");
		System.out.println(DB.getTicketListStr());
		
		UTIL.printDottedLine();
		
		int movieNum = inputNumber("예매할 영화 번호 선택 : ");

		try {
			System.out.println(DB.getTicket(movieNum - 1));
			UTIL.printDottedLine();
			System.out.println("예매를 완료 했습니다.");
			UTIL.printDottedLine();
		} catch(IndexOutOfBoundsException e) {
			System.err.println("잘못된 값을 선택하셨습니다.");
		}
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
			return UTIL.scan.nextInt();
		} catch(InputMismatchException e) {
			UTIL.scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에서 비워줌.
			return Integer.MIN_VALUE; // int의 가장 작은 수를 리턴
		}
	}
}
