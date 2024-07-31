package sjk.sample_2.teamProject.main;

import java.util.Scanner;

import sjk.sample_2.teamProject.controller.TheaterController;

public class Main {
	public static void main(String[] args) {
//		Kiosk tm = new Kiosk();
//		tm.run();
		TheaterController tc = new TheaterController(new Scanner(System.in));
		tc.insertTheater();
	}
}
