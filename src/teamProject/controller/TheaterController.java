package teamProject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import teamProject.model.vo.TheaterVO;
import teamProject.service.TheaterService;
import teamProject.service.TheaterServiceImp;

public class TheaterController extends BaseController {
	private TheaterService theaterService = new TheaterServiceImp();

	public TheaterController(Scanner scan) {
		super(scan);
	}
	
	public void insertTheater() {
		/*List<TheaterVO> list = inputTheater();
		
		if(theaterService.inputTheater(theater)) {
			System.out.println("극장 등록 완료");
		}
		else {
			System.out.println("극장 등록 실패");
		}*/
	}

	public void insertSampleTheater() {
		List<TheaterVO> list = inputTheater();
		
		for(TheaterVO vo : list) {
			theaterService.insertTheater(vo);
		}
	}
	
	private List<TheaterVO> inputTheater() {
		String th_name = "";
		int th_screen = 5;
		int th_seat = 10;
		String th_address = "";
		String th_region = "";
		
		String [] th_names = new String[] {"CGV영등포", "CGV강남", "CGV광교", "CGV계양", "CGV강릉"};
		String [] th_addresss = new String[] {"서울특별시 영등포구 영중로 15 타임스퀘어 4F", "서울특별시 강남구 강남대로 438 스타플렉스 4층~8층", "광교중앙로 124 갤러리아백화점 광교점 10층", "인천광역시 계양구 장제로 738 메트로몰 8층", "강원도 강릉시 경강로 2120"};
		String [] th_regions = new String[]	{"영등포", "강남", "광교", "계양", "강릉"};
		List<TheaterVO> list = new ArrayList<TheaterVO>();
		//i번에 있는 객체를 다른 리스트에 추가하고 그 리스트를 출력?
		for(int i = 0; i < 5; i++) {
			th_name = th_names[i];
			th_screen = 5;
			th_seat = 10;
			th_address = th_addresss[i];
			th_region = th_regions[i];
			TheaterVO vo =  new TheaterVO(th_name, th_screen, th_seat, th_address, th_region);
			list.add(vo);
		}
		return list;
	}
}
