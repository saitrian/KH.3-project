package teamProject.service;

import java.util.List;

import teamProject.model.vo.ScheduleVO;

public interface ScheduleService {
	
	boolean insertSchedule(ScheduleVO schedule);

	List<ScheduleVO> getScheduleList();

}
