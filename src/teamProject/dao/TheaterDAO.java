package teamProject.dao;

import org.apache.ibatis.annotations.Param;

import teamProject.model.vo.TheaterVO;

public interface TheaterDAO {

	boolean inputTheater(@Param("theater")TheaterVO theater);

}
