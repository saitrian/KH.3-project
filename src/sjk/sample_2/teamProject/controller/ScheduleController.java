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
	
	private MovieVO movie;
	private ScreenVO screen;
	private MovieService movieService = new MovieServiceImp();
	private ScheduleService scheduleService = new ScheduleServiceImp();
	
	
	public ScheduleController(Scanner scan) {
		super(scan);
	}

	public void selectMovieNum() {
		movieService.getMovieList(movie);
		List<MovieVO> movieNum = null;
		
		try {
			movieNum = movieService.getNum(movie);
		}
		// 예외 발생 시 등록되지 않은 게시글이거나 삭제된 게시글 입니다. 라고 출력
		catch(Exception e) {
			System.err.println("없음");
			return;
		}
		
		for(MovieVO movieSelectList : movieNum) {
			System.out.println(movieSelectList.getMo_num());
		}

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
		
		System.out.println(movie); // ? 왜 null 값임?
		ScheduleVO schedule1 = new ScheduleVO("10:00", "2024-07-30", movie.getMo_num(), 1);
		ScheduleVO schedule2 = new ScheduleVO("12:00", "2024-07-30", movie.getMo_num(), 1);
		ScheduleVO schedule3 = new ScheduleVO("15:00", "2024-07-30", movie.getMo_num(), 1);
		ScheduleVO schedule4 = new ScheduleVO("18:00", "2024-07-30", movie.getMo_num(), 1);
		ScheduleVO schedule5 = new ScheduleVO("20:00", "2024-07-30", movie.getMo_num(), 1);
		
		/*
		ScheduleVO schedule1 = new ScheduleVO("10:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule2 = new ScheduleVO("12:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule3 = new ScheduleVO("15:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule4 = new ScheduleVO("18:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		ScheduleVO schedule5 = new ScheduleVO("20:00", "2024-07-30", movie.getMo_num(), screen.getSc_num());
		*/
		
		if(scheduleService.insertSchedule(schedule1)
			&& scheduleService.insertSchedule(schedule2)
			&& scheduleService.insertSchedule(schedule3)
			&& scheduleService.insertSchedule(schedule4)
			&& scheduleService.insertSchedule(schedule5)) {
			System.out.println("영화 상영 시간 등록 성공!");
		}else {
			System.err.println("영화 상영 시간 등록 실패...");
		}
	}



}
