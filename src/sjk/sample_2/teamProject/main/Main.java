package sjk.sample_2.teamProject.main;

import java.util.Scanner;

import sjk.sample_2.teamProject.controller.MemberController;

public class Main {
	public static void main(String[] args) {
//		Kiosk tm = new Kiosk();
//		tm.run();
		MemberController mc = new MemberController(new Scanner(System.in));
		mc.insertMember();
	}
}
