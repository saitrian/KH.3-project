package teamProject.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TicketVO {
	private int ti_num; 
	private String ti_me_id; 
	private int ti_sd_num;
	
	
	@Override
	public String toString() {
		return "번호 : " + ti_num + " / " + ti_me_id + " / " + ti_sd_num;
	}
	
	
}
