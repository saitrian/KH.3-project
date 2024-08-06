package sjk.sample_2.teamProject.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.Util;

import sjk.sample_2.teamProject.dao.ScheduleDAO;
import sjk.sample_2.teamProject.important.Utility;
import sjk.sample_2.teamProject.model.tp.NewClass;
import sjk.sample_2.teamProject.model.vo.TicketVO;
import sjk.sample_2.teamProject.service.TicketService;
import sjk.sample_2.teamProject.service.TicketServiceImp;

public class TicketController extends BaseController {
	private TicketService ticketService = new TicketServiceImp();
	private ScheduleDAO scheduleDao ;
	
	public TicketController(Scanner scan) {
		super(scan);
	}

	public void insertTicket(String id, int movieNum) {

		if(ticketService.insertTicket(id, movieNum)){
			System.out.println("예매 성공 !");
		}
		else {
			System.err.println("예매 실패 !");
		}
	}
	

	public TicketVO selectTicket(String id) {
		return ticketService.selectTicket(id);
	}
	
	public int inputNumber(String menuName) {
		try {
			System.out.print(menuName);
			return scan.nextInt();
		} catch(InputMismatchException e) {
			scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에서 비워줌.
			return Integer.MIN_VALUE; // int의 가장 작은 수를 리턴
		}
	}

}
