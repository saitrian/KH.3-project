package sjk.sample_2.teamProject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.ScreenVO;
import sjk.sample_2.teamProject.model.vo.TheaterVO;
import sjk.sample_2.teamProject.service.ScreenService;
import sjk.sample_2.teamProject.service.ScreenServiceImp;
import sjk.sample_2.teamProject.service.TheaterService;
import sjk.sample_2.teamProject.service.TheaterServiceImp;

public class ScreenController extends BaseController {
	private ScreenService screenservice = new ScreenServiceImp();
	private TheaterService theaterservice = new TheaterServiceImp();

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
				//sc_th_num = selectScreent(i);
				ScreenVO sv = new ScreenVO(sc_name, sc_seat, sc_th_num);
				list.add(sv);
			}
		}
		ScreenVO sc = new ScreenVO("1관", 10, 2);
		list.add(sc);
		return list;
	}
	
		public void search() {
			TheaterVO tv = selectScreen(2);
			System.out.println(tv.getTh_name());
		}
	
	private TheaterVO selectScreen(int th_num) {
		TheaterVO tv;
		//i = sc_th_num
		
		//i에 해당하는 theaterVO 의 th_name을 불러오기
		
		//만약 해당하는 th_name이 없으면 존재하지 않는 상영관입니다 출력
		
		return tv = theaterservice.selectThNum(th_num);
	}
}
