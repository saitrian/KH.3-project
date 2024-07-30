package sjk.sample_2.teamProject.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sjk.sample_2.teamProject.controller.MovieController;
import sjk.sample_2.teamProject.model.vo.Ticket;
import sjk.sample_2.teamProject.model.vo.User;

public class Database {
    private static Database instance;
    
    public static Database getInstance() {
        if (instance == null) {
        	instance = new Database();
        }
        
        return instance;
    }
	private Scanner scan = new Scanner(System.in);
    
    private MovieController movieController = new MovieController(scan);
    
	private List<Ticket> ticketList = new ArrayList<Ticket>();
	private List<User> userList = new ArrayList<User>();
	
	public Database() {
		movieController.insert();
		
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
		
		for (int i = 0; i < userList.size(); i++) {
			str += (i + 1) + "번 // " + userList.get(i).toString() + "\n";
		}
		
		return str;
	}
}
