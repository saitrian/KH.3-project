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
		String th_name = "";	//극장 번호
		List<ScreenVO> list = new ArrayList<ScreenVO>();
		//i = 극장 번호, j = 상영관 이름 번호
//		for(int i = 1; i <= 5; i++) {
//			for(int j = 1; j <= 5; j++) {
//				sc_name = j + "관";
//				sc_seat = 10;
//				sc_th_num = i;
//				ScreenVO sv = new ScreenVO(sc_name, sc_seat);
//				list.add(sv);
//			}
//		}
		ScreenVO sv1 = new ScreenVO("1관", 10, "CGV영등포");
		list.add(sv1);
		ScreenVO sv2 = new ScreenVO("2관", 10, "CGV영등포");
		list.add(sv2);
		ScreenVO sv3 = new ScreenVO("3관", 10, "CGV영등포");
		list.add(sv3);
		ScreenVO sv4 = new ScreenVO("4관", 10, "CGV영등포");
		list.add(sv4);
		

		ScreenVO sv5 = new ScreenVO("1관", 10, "CGV강남");
		list.add(sv5);
		ScreenVO sv6 = new ScreenVO("2관", 10, "CGV강남");
		list.add(sv6);
		ScreenVO sv7 = new ScreenVO("3관", 10, "CGV강남");
		list.add(sv7);
		ScreenVO sv8 = new ScreenVO("4관", 10, "CGV강남");
		list.add(sv8);
		

		ScreenVO sv9 = new ScreenVO("1관", 10, "CGV광교");
		list.add(sv9);
		ScreenVO sv10 = new ScreenVO("2관", 10, "CGV광교");
		list.add(sv10);
		ScreenVO sv11 = new ScreenVO("3관", 10, "CGV광교");
		list.add(sv3);
		ScreenVO sv12 = new ScreenVO("4관", 10, "CGV광교");
		list.add(sv12);
		

		ScreenVO sv13 = new ScreenVO("1관", 10, "CGV계양");
		list.add(sv13);
		ScreenVO sv14 = new ScreenVO("2관", 10, "CGV계양");
		list.add(sv14);
		ScreenVO sv15 = new ScreenVO("3관", 10, "CGV계양");
		list.add(sv15);
		ScreenVO sv16 = new ScreenVO("4관", 10, "CGV계양");
		list.add(sv16);
		

		ScreenVO sv17 = new ScreenVO("1관", 10, "CGV강릉");
		list.add(sv17);
		ScreenVO sv18 = new ScreenVO("2관", 10, "CGV강릉");
		list.add(sv18);
		ScreenVO sv19 = new ScreenVO("3관", 10, "CGV강릉");
		list.add(sv19);
		ScreenVO sv20 = new ScreenVO("4관", 10, "CGV강릉");
		list.add(sv20);
		return list;
	}
}
