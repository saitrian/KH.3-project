package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.service.MovieService;
import sjk.sample_2.teamProject.service.MovieServiceImp;

public class MovieController extends BaseController {
	
	private MovieService movieService = new MovieServiceImp(); 
	
	public MovieController(Scanner scan) {
		super(scan);
	}

	@Override
	public boolean insert() {
		MovieVO vo = new MovieVO("탈주", "탈주 영화 내용", 94, "12세 이상", "2024-07-01 12:00");
		
		movieService.insert(vo);
		
		return true;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean select() {
		// TODO Auto-generated method stub
		return false;
	}
}
