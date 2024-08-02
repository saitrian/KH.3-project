package sjk.sample_2.teamProject.controller;

import java.util.List;
import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.ScheduleVO;
import sjk.sample_2.teamProject.model.vo.ScreenVO;
import sjk.sample_2.teamProject.service.MovieService;
import sjk.sample_2.teamProject.service.MovieServiceImp;
import sjk.sample_2.teamProject.service.ScheduleService;
import sjk.sample_2.teamProject.service.ScheduleServiceImp;
public class ScheduleController extends BaseController {
	
	private ScreenVO screen;
	private MovieService movieService = new MovieServiceImp();
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
		
		insertSchedule("10:00", "2024-07-30", "탈주", "");
		insertSchedule("12:00", "2024-07-30", "탈주", "");
		insertSchedule("15:00", "2024-07-30", "탈주", "");
		insertSchedule("18:00", "2024-07-30", "탈주", "");
		insertSchedule("20:00", "2024-07-30", "탈주", "");
		
		/*
		ScheduleVO schedule1 = new ScheduleVO("10:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule2 = new ScheduleVO("12:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule3 = new ScheduleVO("15:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule4 = new ScheduleVO("18:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule5 = new ScheduleVO("20:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		*/
	}

	private void insertSchedule(String time, String date, String movieTitle, String sceenName) {
		MovieVO movieVO;
		ScheduleVO schedule;
		
		movieVO = movieService.selectMovie(movieTitle);
		schedule = new ScheduleVO("10:00", "2024-07-30", movieVO.getMo_num(), 1);

		if(scheduleService.insertSchedule(schedule)) {
			System.out.println("영화 상영 시간 등록 성공!");
		}else {
			System.err.println("영화 상영 시간 등록 실패...");
		}
	}


}
