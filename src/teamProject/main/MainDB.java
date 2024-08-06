package teamProject.main;

import java.util.Scanner;

import teamProject.controller.MemberController;
import teamProject.controller.MovieController;
import teamProject.controller.ScheduleController;
import teamProject.controller.ScreenController;
import teamProject.controller.TheaterController;

public class MainDB {
	public static void main(String[] args) {
		MemberController mc = new MemberController(new Scanner(System.in));
		mc.insertMember();

		MovieController mo = new MovieController(new Scanner(System.in));
		mo.insertMovie();
		
		TheaterController th = new TheaterController(new Scanner(System.in));
		th.insertSampleTheater();
		
		ScreenController sr = new ScreenController(new Scanner(System.in));
		sr.insertScreen();
		
		ScheduleController sc = new ScheduleController(new Scanner(System.in));
		sc.insertSchedule();
	}
}
