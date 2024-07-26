package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

public abstract  class BaseController {
	protected Scanner scan;
	
	public BaseController(Scanner scan) {
		this.scan = scan;
	}
	
	public abstract void insert();
	
	public abstract void update();
	
	public abstract void delete();
	
	public abstract void select();
}
