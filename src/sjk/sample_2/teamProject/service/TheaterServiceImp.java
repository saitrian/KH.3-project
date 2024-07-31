package sjk.sample_2.teamProject.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sjk.sample_2.teamProject.dao.TheaterDAO;
import sjk.sample_2.teamProject.model.vo.TheaterVO;

public class TheaterServiceImp implements TheaterService {

	private TheaterDAO theaterDAO;
	
	public TheaterServiceImp() {
		String resource = "sjk/sample_2/teamProject/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			theaterDAO = session.getMapper(TheaterDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean inputTheater(TheaterVO theater) {
		//극장명 null 체크, 빈 문자열 체크
		if(theater == null) {
			return false;
		}
		;
		return theaterDAO.inputTheater(theater);
	}
}
