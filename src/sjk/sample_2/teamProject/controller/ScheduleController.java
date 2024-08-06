package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.ScheduleVO;
import sjk.sample_2.teamProject.model.vo.ScreenVO;
import sjk.sample_2.teamProject.service.MovieService;
import sjk.sample_2.teamProject.service.MovieServiceImp;
import sjk.sample_2.teamProject.service.ScheduleService;
import sjk.sample_2.teamProject.service.ScheduleServiceImp;
import sjk.sample_2.teamProject.service.ScreenService;
import sjk.sample_2.teamProject.service.ScreenServiceImp;

public class ScheduleController extends BaseController {
	
	private MovieService movieService = new MovieServiceImp();
	// private ScreenService screenService = new ScreenServiceImp();
	private ScheduleService scheduleService = new ScheduleServiceImp();
	
	
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
		
		insertSchedule("10:00", "2024-07-30", "인사이드 아웃2", "1");
		insertSchedule("12:00", "2024-07-30", "인사이드 아웃2", "2");
		insertSchedule("15:00", "2024-07-30", "인사이드 아웃2", "3");
		insertSchedule("18:00", "2024-07-30", "인사이드 아웃2", "4");
		insertSchedule("20:00", "2024-07-30", "인사이드 아웃2", "5");

		insertSchedule("10:00", "2024-07-30", "데드풀과 울버린", "1");
		insertSchedule("12:00", "2024-07-30", "데드풀과 울버린", "2");
		insertSchedule("15:00", "2024-07-30", "데드풀과 울버린", "3");
		insertSchedule("18:00", "2024-07-30", "데드풀과 울버린", "4");
		insertSchedule("20:00", "2024-07-30", "데드풀과 울버린", "5");

		insertSchedule("10:00", "2024-07-30", "어벤져스: 엔드게임", "1");
		insertSchedule("12:00", "2024-07-30", "어벤져스: 엔드게임", "2");
		insertSchedule("15:00", "2024-07-30", "어벤져스: 엔드게임", "3");
		insertSchedule("18:00", "2024-07-30", "어벤져스: 엔드게임", "4");
		insertSchedule("20:00", "2024-07-30", "어벤져스: 엔드게임", "5");

		insertSchedule("10:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "1");
		insertSchedule("12:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "2");
		insertSchedule("15:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "3");
		insertSchedule("18:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "4");
		insertSchedule("20:00", "2024-07-30", "퓨리오사: 매드맥스 사가", "5");
		
		/*
		ScheduleVO schedule1 = new ScheduleVO("10:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule2 = new ScheduleVO("12:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule3 = new ScheduleVO("15:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule4 = new ScheduleVO("18:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule5 = new ScheduleVO("20:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		*/
	}

	private void insertSchedule(String time, String date, String mo_title, String sceenName) {
		MovieVO movieVo;
		//ScreenVO screenVo;
		ScheduleVO schedule;
		
		movieVo = movieService.selectMovie(mo_title);
		// screenVo = screenService.selectScreen(sceenName);
		schedule = new ScheduleVO(time, date, movieVo.getMo_num(), 1);

		if(scheduleService.insertSchedule(schedule)) {
			System.out.println("영화 상영 시간 등록 성공!");
		}else {
			System.err.println("영화 상영 시간 등록 실패...");
		}
	}


}
