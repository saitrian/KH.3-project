package sjk.sample_2.teamProject.main;

import java.util.Scanner;

import sjk.sample_2.teamProject.controller.MemberController;
import sjk.sample_2.teamProject.controller.MovieController;
import sjk.sample_2.teamProject.controller.ScheduleController;
import sjk.sample_2.teamProject.controller.ScreenController;
import sjk.sample_2.teamProject.controller.TheaterController;

public class MainDB {
	public static void main(String[] args) {
//		MemberController mc = new MemberController(new Scanner(System.in));
//		mc.insertMember();
//
//		MovieController mo = new MovieController(new Scanner(System.in));
//		mo.insertMovie();
//		
//		TheaterController th = new TheaterController(new Scanner(System.in));
//		th.insertSampleTheater();
		
		ScreenController sr = new ScreenController(new Scanner(System.in));
		sr.insertScreen();
		
//		ScheduleController sc = new ScheduleController(new Scanner(System.in));
//		sc.insertSchedule();
	}
}
