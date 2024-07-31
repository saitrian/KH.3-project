package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.Ticket;
import sjk.sample_2.teamProject.service.MovieService;
import sjk.sample_2.teamProject.service.MovieServiceImp;

public class MovieController extends BaseController {
	
	private MovieService movieService = new MovieServiceImp(); 
	
	public MovieController(Scanner scan) {
		super(scan);
	}

	public boolean insertMovie(String title, String content, int time, String age, String date) {
		return movieService.insertMovie(new MovieVO(title, content, time, age, date));
	}

	public void createSampleData() {
		movieService.insertMovie(new MovieVO("탈주", "탈주 영화 내용", 94, "12세 이상", "2024-11-11 11:11"));
		movieService.insertMovie(new MovieVO("어벤져스", "어벤져스 영화 내용", 143, "12세 이상", "2024-05-05 05:05"));
	}
}
