package sjk.sample_2.teamProject.service;

import java.util.List;

import sjk.sample_2.teamProject.model.vo.ScheduleVO;

public interface ScheduleService {
	
	boolean insertSchedule(ScheduleVO schedule);

	List<ScheduleVO> getScheduleList();

}
