package teamProject.controller;

import java.util.List;
import java.util.Scanner;

import teamProject.model.vo.MovieVO;
import teamProject.model.vo.ScheduleVO;
import teamProject.model.vo.ScreenVO;
import teamProject.service.MovieService;
import teamProject.service.MovieServiceImp;
import teamProject.service.ScheduleService;
import teamProject.service.ScheduleServiceImp;
import teamProject.service.ScreenService;
import teamProject.service.ScreenServiceImp;

public class ScheduleController extends BaseController {
	
	private MovieService movieService = new MovieServiceImp();
	// private ScreenService screenService = new ScreenServiceImp();
	private ScheduleService scheduleService = new ScheduleServiceImp();
	
	private ScreenController screenController = new ScreenController(scan);
	
	
	public ScheduleController(Scanner scan) {
		super(scan);
	}
	
	public void insertSchedule() {
		
		// 영화 시간, 영화 날짜, 영화 번호(무슨 영화인지 선택), 상영관 번호(상영관 선택)
		/*
		ScheduleVO schedule1 = new ScheduleVO("10:00", "2024-07-30", 1, 1);
		ScheduleVO schedule2 = new ScheduleVO("12:00", "2024-07-30", 1, 1);
		ScheduleVO schedule3 = new ScheduleVO("15:00", "2024-07-30", 1, 1);
		ScheduleVO schedule4 = new ScheduleVO("18:00", "2024-07-30", 1, 1);
		ScheduleVO schedule5 = new ScheduleVO("20:00", "2024-07-30", 1, 1);
		*/
		
		insertSchedule("10:00", "2024-07-30", "탈주", "1");
		insertSchedule("12:00", "2024-07-30", "탈주", "2");
		insertSchedule("15:00", "2024-07-30", "탈주", "3");
		insertSchedule("18:00", "2024-07-30", "탈주", "4");
		insertSchedule("20:00", "2024-07-30", "탈주", "5");
		
		insertSchedule("10:00", "2024-07-30", "인사이드 아웃2", "6");
		insertSchedule("12:00", "2024-07-30", "인사이드 아웃2", "7");
		insertSchedule("15:00", "2024-07-30", "인사이드 아웃2", "8");
		insertSchedule("18:00", "2024-07-30", "인사이드 아웃2", "9");
		insertSchedule("20:00", "2024-07-30", "인사이드 아웃2", "10");

		insertSchedule("10:00", "2024-07-30", "데드풀과 울버린", "11");
		insertSchedule("12:00", "2024-07-30", "데드풀과 울버린", "12");
		insertSchedule("15:00", "2024-07-30", "데드풀과 울버린", "13");
		insertSchedule("18:00", "2024-07-30", "데드풀과 울버린", "14");
		insertSchedule("20:00", "2024-07-30", "데드풀과 울버린", "15");

		insertSchedule("10:00", "2024-07-30", "어벤져스: 엔드게임", "16");
		insertSchedule("12:00", "2024-07-30", "어벤져스: 엔드게임", "17");
		insertSchedule("15:00", "2024-07-30", "어벤져스: 엔드게임", "18");
		insertSchedule("18:00", "2024-07-30", "어벤져스: 엔드게임", "19");
		insertSchedule("20:00", "2024-07-30", "어벤져스: 엔드게임", "20");

		insertSchedule("10:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "21");
		insertSchedule("12:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "22");
		insertSchedule("15:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "23");
		insertSchedule("18:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "24");
		insertSchedule("20:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "25");
		
		/*
		ScheduleVO schedule1 = new ScheduleVO("10:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule2 = new ScheduleVO("12:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule3 = new ScheduleVO("15:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule4 = new ScheduleVO("18:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule5 = new ScheduleVO("20:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		*/
	}

	private void insertSchedule(String time, String date, String mo_title, String screenName) {
		MovieVO movieVo;
		//ScreenVO screenVo;
		ScheduleVO schedule;
		
		movieVo = movieService.selectMovie(mo_title);
		// screenVo = screenService.selectScreen(sceenName);
		schedule = new ScheduleVO(time, date, movieVo.getMo_num(), Integer.parseInt(screenName));

		if(scheduleService.insertSchedule(schedule)) {
			System.out.println("영화 상영 시간 등록 성공!");
		}else {
			System.err.println("영화 상영 시간 등록 실패...");
		}
	}

	public void getScheduleList() {
		List<ScheduleVO> scheduleList = null;
		try {
			scheduleList = scheduleService.getScheduleList();
		}
		// 예외 발생 시 등록되지 않은 게시글이거나 삭제된 게시글 입니다. 라고 출력
		catch(Exception e) {
			System.err.println("없음");
			return;
		}
		
		for(ScheduleVO scheduleSelectList : scheduleList) {
			System.out.println(scheduleSelectList);
		}
		
	}

	
	

}
