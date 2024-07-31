package sjk.sample_2.teamProject.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sjk.sample_2.teamProject.dao.MovieDAO;
import sjk.sample_2.teamProject.model.vo.MovieVO;

public class MovieServiceImp implements MovieService {

	private MovieDAO movieDao;
	
	public MovieServiceImp() {
		String resource = "sjk/sample_2/teamProject/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			movieDao = session.getMapper(MovieDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertMovie(MovieVO movie) {
		if (movie == null) // 예외 처리 추가 요망
			return false;
		
		MovieVO target = movieDao.selectMovie(movie);
		
		if (target != null)
			return false;
		
		return movieDao.insertMovie(movie);
	}
}
