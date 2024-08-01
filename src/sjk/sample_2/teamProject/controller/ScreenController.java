package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.ScreenVO;
import sjk.sample_2.teamProject.service.ScreenService;
import sjk.sample_2.teamProject.service.ScreenServiceImp;

public class ScreenController extends BaseController {
	private ScreenService screenservice = new ScreenServiceImp();

	public ScreenController(Scanner scan) {
		super(scan);
	}
	
	public void insertScreen() {
		ScreenVO screen = inputScreen();
		
		if(screenservice.inputScreen(screen)) {
			System.out.println("좌석 등록 완료");
		}
		else {
			System.out.println("좌석 등록 실패");
		}
	}

	private ScreenVO inputScreen() {
		String sc_name = "4관";//이름(1관, 2관 ...)
		int sc_seat = 10; //총 좌석 수
		int sc_th_num = 5;//극장 번호
		
		
		return new ScreenVO(sc_name, sc_seat, sc_th_num);
	}
}
