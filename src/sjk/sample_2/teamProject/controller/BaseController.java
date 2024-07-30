package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

public abstract class BaseController {
	protected Scanner scan;
	
	public BaseController(Scanner scan) {
		this.scan = scan;
	}
	
	public abstract boolean insert();
	
	public abstract boolean update();
	
	public abstract boolean delete();
	
	public abstract boolean select();
}
