package teamProject.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import teamProject.dao.TicketDAO;
import teamProject.important.Utility;
import teamProject.model.vo.TicketVO;

public class TicketServiceImp implements TicketService {

	private TicketDAO ticketDao;
	
	public TicketServiceImp() {
		String resource = Utility.getInstance().getAddress();
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			ticketDao = session.getMapper(TicketDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertTicket(String id, int num) {

		return ticketDao.insertTicket(id, num);
	}

	@Override
	public TicketVO selectTicket(String id) {
		
		return ticketDao.selectTicket(id);
	}

}
