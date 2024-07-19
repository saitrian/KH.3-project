package ticket;

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
		return "제목 : " + movieName + ", 상영관 : " + theater + ", 날짜 : " + date;
	}
}
