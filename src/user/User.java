package user;

public class User {
	private String name;
	private String password;
	private int point;
	
	public User(String name, String pw, int point) {
		this.name = name;
		this.password = pw;
		
		this.point = 0;
		
	}
	//user의 userlist의 객체가 늘어날때마다 point++
	
	//user가 refound로 영화 예매를 취소하면 point--
			
}
