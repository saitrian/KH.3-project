package sjk.sample_2.teamProject.service;

import java.util.List;

import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.ScheduleVO;

public interface MovieService {
	
	boolean insertMovie(MovieVO movie);

	List<MovieVO> getMovieList(MovieVO movie);

	List<MovieVO> getNum(MovieVO movie);


}
