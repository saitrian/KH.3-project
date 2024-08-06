package sjk.sample_2.teamProject.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.cj.util.Util;

import sjk.sample_2.teamProject.controller.MemberController;
import sjk.sample_2.teamProject.dao.MovieDAO;
import sjk.sample_2.teamProject.dao.ScheduleDAO;
import sjk.sample_2.teamProject.important.Utility;
import sjk.sample_2.teamProject.main.Kiosk;
import sjk.sample_2.teamProject.model.tp.NewClass;
import sjk.sample_2.teamProject.model.vo.MovieVO;
import sjk.sample_2.teamProject.model.vo.ScheduleVO;

public class ScheduleServiceImp implements ScheduleService {

	private final Utility UTIL = Utility.getInstance();
	private ScheduleDAO scheduleDao;
	private MemberController memberController;

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
		if(schedule == null) {
			return false;
		}
		try {			
			return scheduleDao.insertSchedule(schedule);
		}catch(Exception e) {
			return false;
		}

	}

	public void selectMovieInfo(String id) {
		List<NewClass> nc = scheduleDao.selectMovieInfo(id); 
		for(int i = 0 ; i < nc.size() ; i++) {
			System.out.println( (i+1) + "번 : " + nc.get(i) );
		}
	}


	public boolean deleteMovieInfo(String id) {
		List<NewClass> nc = scheduleDao.selectMovieInfo(id); 
		int Tnum = 0;
		for(int i = 0 ; i < nc.size() ; i++) {
			System.out.println( (i+1) + "번 : " + nc.get(i) );
		}
		Tnum = nc.get(inputNumber("환불할 영화표 번호 선택 : ") - 1).getTi_num(); 
		return scheduleDao.deleteMovieInfo(Tnum);
	}


	private int inputNumber(String menuName) {
		try {
			System.out.print(menuName);
			return UTIL.scan.nextInt();
		} catch(InputMismatchException e) {
			UTIL.scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에서 비워줌.
			return Integer.MIN_VALUE; // int의 가장 작은 수를 리턴
		}
	}


	@Override
	public List<ScheduleVO> getScheduleList() {
		return scheduleDao.selectScheduleList();
	}





}
