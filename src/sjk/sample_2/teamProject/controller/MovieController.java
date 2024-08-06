package sjk.sample_2.teamProject.controller;

import java.util.List;
import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.Ticket;
import sjk.sample_2.teamProject.service.MovieService;
import sjk.sample_2.teamProject.service.MovieServiceImp;

public class MovieController extends BaseController {
	
	private MovieService movieService = new MovieServiceImp();
	private MovieVO movie;

	public MovieController(Scanner scan) {
		super(scan);
	}
	
	public void insertMovie() {
		MovieVO movie = new MovieVO("탈주", "탈주 내용", 127, "15세", "2024-07-03");
		MovieVO movie2 = new MovieVO("인사이드 아웃2", "인사이드 내용", 210, "12세", "2024-06-12");
		MovieVO movie3 = new MovieVO("데드풀과 울버린", "데드풀과 울버린 내용", 150, "19세", "2023-07-31");
		MovieVO movie4 = new MovieVO("어벤져스: 엔드게임", "어벤져스: 엔드게임 내용", 300, "15세", "2019-04-24");
		MovieVO movie5 = new MovieVO("퓨리오사: 매드맥스 사가", "퓨리오사: 매드맥스 사가 내용", 120, "12세", "2024-05-23");
		
		if(movieService.insertMovie(movie)
			&& movieService.insertMovie(movie2)
			&& movieService.insertMovie(movie3)
			&& movieService.insertMovie(movie4)
			&& movieService.insertMovie(movie5)) {
			System.out.println("영화 등록 성공!");
		}else {
			System.err.println("영화 등록 실패...");
		}
		
	}

	public void getMovieList() {		
		List<MovieVO> movieList = null;
		try {
			movieList = movieService.getMovieList();
		}
		// 예외 발생 시 등록되지 않은 게시글이거나 삭제된 게시글 입니다. 라고 출력
		catch(Exception e) {
			System.err.println("없음");
			return;
		}
		
		for(MovieVO movieSelectList : movieList) {
			System.out.println(movieSelectList);
		}
		
	}
	

	public MovieVO selectMovie(String search) {
		// 영화 상영작 목록에서 검색어가 제목에 들어간 게시글 리스트를 가져옴
		List<MovieVO> searchMovieList = null;
		try {
			searchMovieList = movieService.getSearchMovieList(search);
		}
		// 예외 발생 시 등록되지 않은 게시글이거나 삭제된 게시글 입니다. 라고 출력
		catch(Exception e) {
			System.err.println("없음");
			return null;
		}
		
		// ticketList에 영화가 없으면 종료
		if(searchMovieList.size() == 0) {
			System.err.println("검색된 영화가 없습니다.");
			return null;
		}

		// 현재 searchList에 저장된 상영작 목록 출력
		System.out.println("-----검색된 상영작 목록-----");
		for(MovieVO movieList : searchMovieList) {
			System.out.println(movieList);
		}
		System.out.println("-------------------");

		// 메뉴로 돌아가려면... 문구 출력
		//System.err.print("메뉴로 돌아가려면 엔터를 치세요.");

		// 엔터를 입력받도록 처리
		//scan.nextLine(); // 입력한 엔터 처리
		
		return movieService.selectMovie(search);
	}

	
}
