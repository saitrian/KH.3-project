package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.MovieVO;

public interface MovieDAO {
	
	public boolean insert(@Param("obj")MovieVO obj);
	
	public boolean update(@Param("obj")MovieVO obj);
	
	public boolean delete(@Param("obj")MovieVO obj);
	
	public MovieVO select(@Param("obj")MovieVO obj);
}
