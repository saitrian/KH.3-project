package sjk.sample_2.teamProject.main;

import java.util.Scanner;

import sjk.sample_2.teamProject.controller.MemberController;
import sjk.sample_2.teamProject.controller.MovieController;
import sjk.sample_2.teamProject.controller.ScheduleController;
import sjk.sample_2.teamProject.controller.TicketController;

public class Main {
	public static void main(String[] args) {
		Kiosk tm = new Kiosk();
		tm.run();
		
//		MemberController mc = new MemberController(new Scanner(System.in));
//		mc.insertMember();
//		TicketController tc = new TicketController(new Scanner(System.in));
//		tc.insertTicket();

//		MovieController mc = new MovieController(new Scanner(System.in));
//		mc.insertMovie();
//		mc.getMovieList();		
		
//		ScheduleController sc = new ScheduleController(new Scanner(System.in));
//		sc.insertSchedule();
	}
}
