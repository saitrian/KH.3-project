package sjk.kiosk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CinemaInfo {
	private SimpleDateFormat cinemaInfoFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분"); 
	
	private MovieInfo movieInfo;
	private String cinemaName;
	private String date;
	
	public CinemaInfo(String movieName, String cinemaName, Date date) {
		this.movieInfo = new MovieInfo(movieName);
		this.cinemaName = cinemaName;
		this.date = cinemaInfoFormat.format(date);
	}

	@Override
	public String toString() {
		return "제목 : " + movieInfo + "\n상영관 : " + cinemaName + "\n상영 시간 : " + date;
	}	
}
