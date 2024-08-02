package sjk.sample_2.teamProject.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sjk.sample_2.teamProject.dao.TicketDAO;
import sjk.sample_2.teamProject.model.vo.MemberVO;
import sjk.sample_2.teamProject.model.vo.TicketVO;

public class TicketServiceImp implements TicketService {

	private TicketDAO ticketDao;
	
	public TicketServiceImp() {
		String resource = "sjk/sample_2/teamProject/config/mybatis-config.xml";
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
	public boolean insertTicket(String id) {

		return ticketDao.insertTicket(id);
	}

	@Override
	public boolean insertTicket2(String pw) {
		// 받아온 비번을 다오에게 넘겨주고 비번과 일치하는 멤버 정보 가져오게 시킴
		MemberVO member = ticketDao.selectMember(pw);
		if(member == null) {
			return false;
		}
		// 비번과 일치하는 멤버 정보 받아왔으니까 id(key값) 다오에게 주고 예매하게 시킴
		return ticketDao.insertTicket(member.getMe_id());
	}

}
