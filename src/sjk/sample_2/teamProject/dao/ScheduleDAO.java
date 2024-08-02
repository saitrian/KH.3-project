package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.ScheduleVO;

public interface ScheduleDAO {
	
	boolean insertSchedule(@Param("sd")ScheduleVO schedule);

}
