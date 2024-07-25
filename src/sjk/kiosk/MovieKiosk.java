package sjk.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieKiosk {
	private Scanner scan = new Scanner(System.in);
	
	private List<CinemaInfo> cinemaInfoList;
	private LoginSystem loginSystem;
	
	private DataBase db;
	
	public void connectDB(DataBase db) {
		this.db = db;
	}
	
	public void excute() {
		cinemaInfoList = new ArrayList<CinemaInfo>(db.getCinemaList());
		loginSystem = new LoginSystem(db.getUserlist());
		
		while (true) {
			printMenu();
			
			switch (scan.nextInt()) {
			case 1:	
				buyMovieTicket();
				break;
			case 2:
				cancleMovieTicket();				
				break;
			case 3:
				printTicketList();
				break;
			default:
				break;
			}
		}
	}
	
	public void printMenu() {
		System.out.println("--- M E N U ---");
		System.out.println("1. 영화 예매");
		System.out.println("2. 예매 취소");
		System.out.println("3. 예매 조회");
	}
	
	public void printMovieList() {
		for (int i = 0; i < cinemaInfoList.size(); ++i) {
			System.out.println((i + 1) + "번 -- " + cinemaInfoList.get(i));
		}
	}
	
	public void printTicketList() {
		System.out.println(db.getTicketListStr());
	}
	
	public void buyMovieTicket() {
		printMovieList();
		
		int num = selectNumber();
		
		String id = confirmLogin();
		
		if (id == "")
			return;
		
		MovieTicket ticketInfo = new MovieTicket(cinemaInfoList.get(num), id);
		
		db.addTicket(ticketInfo);
	}
	
	public void cancleMovieTicket() {
		printTicketList();

		int num = selectNumber();
		MovieTicket ticket = db.getMovieTicket(num);
		
		if (loginSystem.checkPassword(ticket.getUserName()) == false) {
			System.out.println("비밀번호가 틀림");
			return;
		}
		
		db.removeTicket(ticket);
	}
	
	public int selectNumber() {
		System.out.println("번호 : ");
		return scan.nextInt() - 1;
	}
	
	public String confirmLogin() {		
		String id = loginSystem.confirmLogin();
		
		if (id == "") {
			System.out.println("로그인 실패 : " + id);
		}
		
		return id;
	}
}
