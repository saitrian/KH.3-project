package sjk.sample_2.teamProject.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sjk.sample_2.teamProject.dao.MemberDAO;
import sjk.sample_2.teamProject.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;

	public MemberServiceImp() {
		String resource = "sjk/sample_2/teamProject/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertMember(String id, String pw, String authority, int point) {
		return memberDao.insertMember(id, pw, authority, point);
	}

	@Override
	public boolean login(String id, String pw) {
		// null체크, 빈 문자열 체크
		if(id == null || id.trim().length() == 0 || pw == null || pw.trim().length() == 0) {
			return false;
		}
		id = id.trim();
		// 아이디 확인
		MemberVO memberVo = memberDao.selectMember(id);
		if(memberVo == null) {
			return false;
		}

		MemberVO user = memberDao.selectMember(id);

		if(user == null) {
			return false;
		}
		// 회원 정보가 있으면 회원의 비번과 입력받은 비번을 확인
		if(user.getMe_pw().equals(pw)) {
			return true;
		}
		return false;
	}

	@Override
	public void updateUpPoint(String id) {
		memberDao.updateUpPoint(id);
		System.out.println("'1' 포인트 적립되었습니다.");
	}

	@Override
	public void updateUsePoint(String id) {
		MemberVO user = memberDao.selectMember(id);
		if(user.getMe_point() == 0) {
			memberDao.updateUpPoint(id);
			System.out.println("보유하신 포인트가 없어 자동으로 적립합니다.");
			System.out.println("'1' 포인트 적립되었습니다.");
		}else {
		memberDao.updateUsePoint(id);
		}
	}

	@Override
	public void searchPoint(String id) {
		MemberVO user = memberDao.selectMember(id);
		System.out.println(id + "님의 보유 포인트");
		System.out.println("[ " + user.getMe_point() + " 포인트 ]");
	}
}
