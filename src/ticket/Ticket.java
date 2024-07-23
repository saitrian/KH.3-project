package ticket;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// 무엇인지
public class Ticket {
	// 무엇인지
	private String movieName;
	// 얘는 무엇ㅇ니지
	private String theater;
	private String date;	
	
	@Override
	// 무엇ㅇ니지
	public String toString() {
		// 얘가 행위가 
		return "제목 : " + movieName + ", 상영관 : " + theater + ", 날짜 : " + date;
	}
}
