package sjk.sample_2.teamProject.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import sjk.sample_2.teamProject.important.Utility;
import sjk.sample_2.teamProject.service.TicketService;
import sjk.sample_2.teamProject.service.TicketServiceImp;


public class TicketController extends BaseController {
	private final Utility UTIL = Utility.getInstance();
	private TicketService ticketService = new TicketServiceImp();
	private MemberController memberController = new MemberController(scan);

	public TicketController(Scanner scan) {
		super(scan);
	}

	public void insertTicket() {
		String id = memberController.login();
		UTIL.printDottedLine();
		int movieNum = inputNumber("예매할 영화 번호 선택 : ");
		
		if((id.equals("xxx"))) {
			return;
		}

		if(ticketService.insertTicket(id, movieNum)){
			System.out.println("예매 성공 !");
		}
		else {
			System.err.println("예매 실패 !");
		}
	}


	//key 값이 아닌 비번 주고 db에서 해당하는 key값 가져와서 insert
	public void insertTicket2() {
		// 비번(key값 아님) 입력 받고
		System.out.print("비번 입력 : ");
		String pw = scan.next();

		// 서비스에게 비번주기
		if(ticketService.insertTicket2(pw)) {
			System.out.println("예매 성공!");
		}
		else {
			System.err.println("예매 실패!");
		}
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
