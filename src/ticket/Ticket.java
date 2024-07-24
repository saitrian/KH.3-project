package ticket;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// TicketManager 에서 사용하기 위한 Ticket 클래스 생성
public class Ticket {
	//Ticket에 포함될 맴버 변수들을 생성
	// 영화 이름 생성
	private String movieName;
	// 상영관과 상영일 생성
	private String theater;
	private String date;	
	
	@Override
	// 객체의 값을 문자열로 나타내기 위한 메서드
	public String toString() {
		// toString 에서 출력되는 값을 바꾸기 
		return "제목 : " + movieName + ", 상영관 : " + theater + ", 날짜 : " + date;
	}
}
