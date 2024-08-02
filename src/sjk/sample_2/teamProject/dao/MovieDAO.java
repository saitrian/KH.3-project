package sjk.sample_2.teamProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.MovieVO;

public interface MovieDAO {

	boolean insertMovie(@Param("mo")MovieVO movie);
	
	MovieVO selectMovie(@Param("mo")MovieVO movie);

	List<MovieVO> selectMovieList(@Param("mo")MovieVO movie);

	List<MovieVO> selectNum(@Param("mo")MovieVO movie);

	
	
}
