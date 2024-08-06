package teamProject.dao;

import org.apache.ibatis.annotations.Param;

import teamProject.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("id")String id, @Param("pw")String pw, 
			@Param("authority")String authority, @Param("point")int point);

	MemberVO selectMember(@Param("id")String id);

	void updateUpPoint(@Param("id")String id);

	void updateUsePoint(@Param("id")String id);

	
}
