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
	
	public void insertTheater() {
		TheaterVO theater = inputTheater();
		
		if(theaterService.inputTheater(theater)) {
			System.out.println("극장 등록 완료");
		}
		else {
			System.out.println("극장 등록 실패");
		}
	}

	private TheaterVO inputTheater() {
		String th_name = "cgv강남";
		int th_screen = 4;
		int th_seat = 10;
		String th_address = "서울";
		String th_region = "강남";
		return new TheaterVO(th_name, th_screen, th_seat, th_address, th_region);
	}
}
