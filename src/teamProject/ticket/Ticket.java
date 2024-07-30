package teamProject.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
	private String movieName;
	private String genre;
	private String theater;
	private String date;	
	
	@Override
	public String toString() {
		//원하는 출력 메세지를 만들기 위해 수정
		return "영화 이름 : " + movieName + " / 장르 : " + genre + " / 날짜 : " + date + " / 상영관 : " + theater + "관";
	}
}
