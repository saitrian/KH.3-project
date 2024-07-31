package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.TheaterVO;

public interface TheaterDAO {

	TheaterVO selectTheater(@Param("th")TheaterVO theater);

	boolean insertTheater(@Param("th")TheaterVO theater);

}
