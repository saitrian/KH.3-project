package teamProject.database;

import java.util.ArrayList;
import java.util.List;

import teamProject.important.Utility;
import teamProject.ticket.Ticket;
import teamProject.user.User;

public class Database {
    private static Database instance;
    //인터페이스 생성
    public static Database getInstance() {
    	//만약 인터페이스가 없으면 새로 생성
        if (instance == null) {
        	instance = new Database();
        }
        
        return instance;
    }
    //영화 리스트 ticketList 생성
	private List<Ticket> ticketList = new ArrayList<Ticket>();
	//유저 리스트 userList 생성
	private List<User> userList = new ArrayList<User>();
	//ticketList와 userList에 객체를 생성시키기 위한 메서드
	public Database() {
		ticketList.add(new Ticket("탈주", "1" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("탈주", "2" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("탈주", "3" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("어벤져스", "4" , "2024-07-01 12:00"));
		ticketList.add(new Ticket("어벤져스", "5" , "2024-07-01 12:00"));

		userList.add(new User("aaa", "111"));
		userList.add(new User("bbb", "222"));
	}
	
	public List<Ticket> getTicketList() {
		return ticketList;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	
	public String getTicketListStr() {
		String str = "";
		//i의 크기가 ticketList보다 작다면 i++, ticketList의 i번지에 해당하는 객체를 출력
		for (int i = 0; i < ticketList.size(); i++) {
			str += (i + 1) + "번 // " + ticketList.get(i).toString() + "\n";
		}
		
//		for (Ticket ticket : ticketList) {
//			str += ticket.toString() + "\n";
//		}
		
		return str;
	}
	
	public String getUserListStr() {
		String str = "";
		//i의 크기가 userList보다 작다면 i++, userList의 i번지에 해당하는 객체를 출력
		for (int i = 0; i < userList.size(); i++) {
			str += (i + 1) + "번 // " + userList.get(i).toString() + "\n";
		}
		
		return str;
	}
}
