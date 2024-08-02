package sjk.sample_2.teamProject.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sjk.sample_2.teamProject.dao.ScreenDAO;
import sjk.sample_2.teamProject.model.vo.ScreenVO;

public class ScreenServiceImp implements ScreenService {

	private ScreenDAO screenDAO;
	
	public ScreenServiceImp() {
		String resource = "sjk/sample_2/teamProject/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			screenDAO = session.getMapper(ScreenDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertScreen(ScreenVO screen) {
		if(screen == null) {
			return false;
		}
		return screenDAO.insertScreen(screen);
	}
}
