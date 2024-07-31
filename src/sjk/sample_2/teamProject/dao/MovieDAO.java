package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.MovieVO;

public interface MovieDAO {
	public MovieVO selectMovie(@Param("mo")MovieVO movie);

	public boolean insertMovie(@Param("mo")MovieVO movie);
}
