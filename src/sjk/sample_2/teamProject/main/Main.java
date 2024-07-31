package sjk.sample_2.teamProject.main;

import java.util.Scanner;

import sjk.sample_2.teamProject.controller.MovieController;

public class Main {
	public static void main(String[] args) {
		//Kiosk tm = new Kiosk();
		//tm.run();
		MovieController mc = new MovieController(new Scanner(System.in));
		mc.insertMovie();
	}
}
