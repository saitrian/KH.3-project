package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me")MemberVO member);

	boolean insertMember(@Param("me")MemberVO member);

}
