package sjk.sample_2.teamProject.controller;

import java.util.ArrayList;
import java.util.List;
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
		List<ScreenVO> list = inputScreen();
		
		for(ScreenVO sv : list) {
			screenservice.insertScreen(sv);
		}
	}

	private List<ScreenVO> inputScreen() {
		String sc_name = "";//이름(1관, 2관 ...)
		int sc_seat = 10;	//총 좌석 수
		int sc_th_num = 1;	//극장 번호
		List<ScreenVO> list = new ArrayList<ScreenVO>();
		//i = 극장 번호, j = 상영관 이름 번호
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				sc_name = j + "관";
				sc_seat = 10;
				sc_th_num = i;
				ScreenVO sv = new ScreenVO(sc_name, sc_seat, sc_th_num);
				list.add(sv);
			}
		}
		return list;
	}
}
