package sjk.sample_2.teamProject.dao;

import org.apache.ibatis.annotations.Param;

import sjk.sample_2.teamProject.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("id")String id, @Param("pw")String pw, 
			@Param("authority")String authority, @Param("point")int point);

}
