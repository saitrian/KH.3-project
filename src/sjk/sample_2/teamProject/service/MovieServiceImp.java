package sjk.sample_2.teamProject.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
		if(movie == null) {
			return false;
		}
		
		MovieVO movieVo = movieDao.selectMovie(movie);
		
		if(movieVo != null) {
			System.err.println("이미 등록된 영화 이름 입니다.");
			return false;
		}
		
		return movieDao.insertMovie(movie);
	}

	@Override
	public List<MovieVO> getMovieList() {
		return movieDao.selectMovieList();
	}

	@Override
	public MovieVO selectMovie(String mo_title) {
		return movieDao.selectMovie_useTitle(mo_title);
	}

	@Override
	public List<MovieVO> getSearchMovieList(String search) {
		return movieDao.selectSearchMovieList(search);
	}

	/*
	@Override
	public MovieVO selectMovie(String movieName) {
		MovieVO movieVo = new MovieVO(movieName);
		
		return movieDao.selectMovie(movieVo);
		
		return movieDao.selectMovie_useTitle(movieName);
	}
	*/

}
