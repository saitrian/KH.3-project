package sjk.kiosk;

import java.util.Map;
import java.util.TreeMap;

public class UserList {
	private Map<String, String> userDatas;

	public UserList() {
		super();
		this.userDatas = new TreeMap<String, String>();
	}
	
	public boolean add(String id, String password) {
		if (userDatas.containsKey(id)) {
			System.out.println("존재하는 id");
			return false;
		}

		userDatas.put(id, password);
		
		return true;
	}
	
	public boolean contain(String id, String password) {
		if (userDatas.containsKey(id) == false) {
			System.out.println("존재하지 않는 id : " + id);
			return false;	
		}
		
		if (userDatas.get(id).equals(password) == false) {
			System.out.println("비밀번호 에러");
			return false;
		}
		
		return true;
	}
}
