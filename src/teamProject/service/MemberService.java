package teamProject.service;

import teamProject.model.vo.MemberVO;

public interface MemberService {

	boolean insertMember(String id, String pw, String authority, int point);

	boolean login(String id, String pw);

	void updateUpPoint(String id);

	void updateUsePoint(String id);

	void searchPoint(String id);

}