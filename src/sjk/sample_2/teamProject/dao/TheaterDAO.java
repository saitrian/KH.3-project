package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.TheaterVO;

public interface TheaterDAO {

	boolean inputTheater(@Param("theater")TheaterVO theater);

	TheaterVO selectThNum(@Param("thNum")int th_num);

}
