package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

public abstract class BaseController {
	protected Scanner scan;
	
	public BaseController(Scanner scan) {
		this.scan = scan;
	}
}
