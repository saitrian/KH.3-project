package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.ScheduleVO;
import sjk.sample_2.teamProject.service.ScheduleService;
import sjk.sample_2.teamProject.service.ScheduleServiceImp;

public class ScheduleController extends BaseController {
	
	private ScheduleService scheduleService = new ScheduleServiceImp();
	
	
	public ScheduleController(Scanner scan) {
		super(scan);
	}
	
	public void insertSchedule() {
		ScheduleVO schedule = new ScheduleVO("20:00", "2024-07-30", 1, 1);
	}
}
