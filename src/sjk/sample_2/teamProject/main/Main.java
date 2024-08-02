package sjk.sample_2.teamProject.main;

import java.util.Scanner;

import sjk.sample_2.teamProject.controller.ScreenController;

public class Main {
	public static void main(String[] args) {
//		Kiosk tm = new Kiosk();
//		tm.run();
		//극장 실행
//		TheaterController tc = new TheaterController(new Scanner(System.in));
//		tc.insertSampleTheater();
		
		//상영관 실행
		ScreenController sc = new ScreenController(new Scanner(System.in));
		sc.insertScreen();
	}
}
