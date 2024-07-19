package sjk;

import java.util.Date;

public class MovieTicket {

	private CinemaInfo cinemaInfo;
	private String userName;
	
	public MovieTicket(CinemaInfo cinemaInfo, String userName) {
		super();
		this.cinemaInfo = cinemaInfo;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return cinemaInfo + "\n예매자 : " + userName;
	}
	
	public String getUserName() {
		return userName;
	}
}
