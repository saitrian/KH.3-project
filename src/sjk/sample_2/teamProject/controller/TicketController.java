package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.service.TicketService;
import sjk.sample_2.teamProject.service.TicketServiceImp;


public class TicketController extends BaseController {
	
	private TicketService ticketService = new TicketServiceImp();
	
	public TicketController(Scanner scan) {
		super(scan);
	}
	
//	public boolean insertTicket() {
//		String id;
//		
//	}
}
