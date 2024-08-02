package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.MemberVO;

public interface TicketDAO {


	boolean insertTicket(@Param("id")String id, @Param("num")int num);

	MemberVO selectMember(@Param("pw")String pw);

}
