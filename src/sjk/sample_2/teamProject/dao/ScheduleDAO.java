package sjk.sample_2.teamProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.tp.NewClass;
import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.ScheduleVO;

public interface ScheduleDAO {
	
	boolean insertSchedule(@Param("sd")ScheduleVO schedule);
	
	List<NewClass> selectMovieInfo(@Param("id")String id);

	List<ScheduleVO> selectScheduleList();

	boolean deleteMovieInfo(@Param("ti_num")int tiNum);
}
