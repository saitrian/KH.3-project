package sjk.sample_2.teamProject.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	private String me_id; 
	private String me_pw; 
	private String me_authority; 
	private int me_point;
	
	public MemberVO(String me_id, String me_pw) {
		super();
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_authority = "member";
	}
	
	public MemberVO(String me_id, String me_pw, String me_authority) {
		super();
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_authority = me_authority;
	}

	@Override
	public String toString() {
		return me_id + " - 포인트 : " + me_point;
	}
}
