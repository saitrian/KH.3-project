package sjk.sample_2.teamProject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
	private String movieName;
	private String theater;
	private String date;	
	
	@Override
	public String toString() {
		return "상영관 " + theater + "관 / "+ movieName + " / 날짜 : " + date;
	}
}
