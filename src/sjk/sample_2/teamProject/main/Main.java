package sjk.sample_2.teamProject.main;

import java.util.Scanner;

import sjk.sample_2.teamProject.controller.MovieController;
import sjk.sample_2.teamProject.controller.ScheduleController;
import sjk.sample_2.teamProject.model.vo.MovieVO;

public class Main {
	public static void main(String[] args) {
		/*
		Kiosk tm = new Kiosk();
		tm.run();
		*/
		
		/*
		MovieVO movie = null;
		MovieController mc = new MovieController(new Scanner(System.in));
		mc.insertMovie();
		// mc.getMovieList();
		*/
		
		ScheduleController sc = new ScheduleController(new Scanner(System.in));
		sc.insertSchedule();
		
	}
}