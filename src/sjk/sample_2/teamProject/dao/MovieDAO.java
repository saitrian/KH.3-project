package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.MovieVO;

public interface MovieDAO {

	MovieVO selectMovie(@Param("mo")MovieVO movie);

	boolean insertMovie(@Param("mo")MovieVO movie);
	
}
