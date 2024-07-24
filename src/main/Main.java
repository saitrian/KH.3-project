package main;

import ticket.TicketManager;

public class Main {
	public static void main(String[] args) {
		//TicketManager 클래스를 불러와서 TicketManager 안에 있는 run() 메서드를 실행
		TicketManager tm = new TicketManager();
		tm.run();
	}
}
