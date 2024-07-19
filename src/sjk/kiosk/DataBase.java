package sjk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
	private SimpleDateFormat cinemaInfoFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private List<CinemaInfo> cinemaList = new ArrayList<CinemaInfo>();
	private UserList userlist = new UserList();
	private List<MovieTicket> ticketList = new ArrayList<MovieTicket>();
	
	public DataBase() {
		try {
			cinemaList.add(new CinemaInfo("AAAA", "1관", cinemaInfoFormat.parse("20240718211530")));
			cinemaList.add(new CinemaInfo("BBBB", "1관", cinemaInfoFormat.parse("20240718151530")));
			cinemaList.add(new CinemaInfo("CCCC", "1관", cinemaInfoFormat.parse("20240718091530")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userlist.add("aaa", "111");
		userlist.add("bbb", "222");
	}
	
	public List<CinemaInfo> getCinemaList() {
		return cinemaList;
	}
	
	public UserList getUserlist() {
		return userlist;
	}
	
	public boolean addTicket(MovieTicket ticket) {		
		return ticketList.add(ticket);
	}
	
	public String getTicketListStr() {
		String str = "";
		
		for (int i = 0; i < ticketList.size(); ++i) {
			str += (i + 1) + "번 -- " + ticketList.get(i) + "\n";
		}
		
		return str;
	}
	
	public boolean removeTicket(MovieTicket ticket) {
		return ticketList.remove(ticket);
	}
	
	public MovieTicket getMovieTicket(int num) {
		return ticketList.get(num);
	}
}
