package sjk.sample_2.teamProject.model.tp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewClass {
	private String mo_title;
	private int sc_num;
	private String sd_date;
	private String sd_time;
	private String th_name;
	@Override
	public String toString() {
		return "영화 제목 : [" + mo_title + "] / 상영일 : [" + sd_date + "] [" + sd_time +  "] / 상영관 [" + sc_num + "] / 영화관 : [" + th_name +"]"
				;
	}
	
	
	
}
