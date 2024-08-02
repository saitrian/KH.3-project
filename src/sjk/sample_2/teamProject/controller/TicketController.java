package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.service.TicketService;
import sjk.sample_2.teamProject.service.TicketServiceImp;


public class TicketController extends BaseController {
	
	private TicketService ticketService = new TicketServiceImp();
	private MemberController memberController = new MemberController(scan);
	
	public TicketController(Scanner scan) {
		super(scan);
	}
	
	public void insertTicket() {
		String id = memberController.login();
		
		if((id.equals("xxx"))) {
			return;
		}
		
		if(ticketService.insertTicket(id)){
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
}
