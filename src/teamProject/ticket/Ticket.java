package teamProject.ticket;

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
		//원하는 출력 메세지를 만들기 위해 수정
		return "상영관 " + theater + "관 / "+ movieName + " / 날짜 : " + date;
	}
}
