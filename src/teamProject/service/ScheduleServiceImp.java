package teamProject.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import teamProject.controller.MemberController;
import teamProject.dao.ScheduleDAO;
import teamProject.important.Utility;
import teamProject.model.tp.NewClass;
import teamProject.model.vo.ScheduleVO;

public class ScheduleServiceImp implements ScheduleService {

	private ScheduleDAO scheduleDao;

	public ScheduleServiceImp() {
		String resource = Utility.getInstance().getAddress();
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
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print(menuName);
			return scan.nextInt();
		} catch(InputMismatchException e) {
			scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에서 비워줌.
			return Integer.MIN_VALUE; // int의 가장 작은 수를 리턴
		}
	}


	@Override
	public List<ScheduleVO> getScheduleList() {
		return scheduleDao.selectScheduleList();
	}





}
