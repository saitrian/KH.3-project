package teamProject.dao;

import org.apache.ibatis.annotations.Param;

import teamProject.model.vo.ScreenVO;

public interface ScreenDAO {

	boolean insertScreen(@Param("screen")ScreenVO screen);

	ScreenVO selectScreen(@Param("screenName")String screenName);

}
