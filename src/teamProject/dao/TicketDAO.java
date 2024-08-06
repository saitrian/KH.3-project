package teamProject.dao;

import org.apache.ibatis.annotations.Param;

import teamProject.model.vo.MemberVO;
import teamProject.model.vo.TicketVO;

public interface TicketDAO {

	boolean insertTicket(@Param("id")String id, @Param("num")int num);

	MemberVO selectMember(@Param("pw")String pw);

	TicketVO selectTicket(@Param("id")String id);
}
