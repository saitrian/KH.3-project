package user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String name;
	private String password;
	
	private int point;
	
	public User(String name, String pw) {
		this.name = name;
		this.password = pw;
		
		this.point = 0;
	}
}
