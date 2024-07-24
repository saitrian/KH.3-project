package teamProject.user;

public class User {
	private String name;
	private String password;
	
	private int point;
	
	public User(String name, String pw) {
		this.name = name;
		this.password = pw;
		
		this.point = 0;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getPoint() {
		return point;
	}
}
