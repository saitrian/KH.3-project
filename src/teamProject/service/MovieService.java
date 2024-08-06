package teamProject.service;

import java.util.List;

import teamProject.model.vo.MovieVO;

public interface MovieService {
	
	boolean insertMovie(MovieVO movie);

	List<MovieVO> getMovieList();

	MovieVO selectMovie(String mo_title);

	List<MovieVO> getSearchMovieList(String search);
}