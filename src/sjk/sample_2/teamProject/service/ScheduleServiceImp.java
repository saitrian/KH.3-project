package sjk.sample_2.teamProject.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sjk.sample_2.teamProject.dao.MovieDAO;
import sjk.sample_2.teamProject.dao.ScheduleDAO;
import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.ScheduleVO;

public class ScheduleServiceImp implements ScheduleService {

	private ScheduleDAO scheduleDao;
	
	public ScheduleServiceImp() {
		String resource = "sjk/sample_2/teamProject/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			scheduleDao = session.getMapper(ScheduleDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean insertSchedule(ScheduleVO schedule) {
//		if(schedule == null) {
//			return false;
//		}
//		try {			
//			return scheduleDao.insertSchedule(schedule);
//		}catch(Exception e) {
//			return false;
//		}
		System.out.println(scheduleDao.selectMovieInfo("aaa"));
		return false;
	}



}
