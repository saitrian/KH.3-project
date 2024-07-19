package teamProject.database;

import java.util.ArrayList;
import java.util.List;

import teamProject.ticket.Ticket;
import teamProject.user.User;

public class Database {
	private List<Ticket> ticketList = new ArrayList<Ticket>();
	private List<User> userList = new ArrayList<User>();
	
	public Database() {
		ticketList.add(new Ticket("탈주", "1" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("탈주", "2" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("탈주", "3" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("어벤져스", "4" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("어벤져스", "5" , "2024-07-01 12:00"));

		userList.add(new User("aaa", "111"));
		userList.add(new User("bbb", "222"));
	}
	
	public Ticket getTicket(int index) {		
		return ticketList.get(index);
	}
	
	public User getUser(int index) {
		return userList.get(index);
	}
	
	public String getTicketListStr() {
		String str = "";
		
		for (int i = 0; i < ticketList.size(); i++) {
			str += i + "번 // " + ticketList.get(i).toString() + "\n";
		}
		
//		for (Ticket ticket : ticketList) {
//			str += ticket.toString() + "\n";
//		}
		
		return str;
	}
	
	public String getUserListStr() {
		String str = "";
		
		for (int i = 0; i < userList.size(); i++) {
			str += i + "번 // " + userList.get(i).toString() + "\n";
		}
		
		return str;
	}
}
