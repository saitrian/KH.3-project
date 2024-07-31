package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.TheaterVO;
import sjk.sample_2.teamProject.service.TheaterService;
import sjk.sample_2.teamProject.service.TheaterServiceImp;

public class TheaterController extends BaseController {

	private TheaterService theaterService = new TheaterServiceImp();
	
	public TheaterController(Scanner scan) {
		super(scan);
	}

	public void createSampleData() {
		theaterService.insertTheater(new TheaterVO("CGV", 5, 5, "강남1", "강남2"));
	}
}
