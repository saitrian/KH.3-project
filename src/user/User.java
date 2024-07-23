package user;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String password;
	private int point;

	public User(String name, String pw, int point) {
		private List<String> reslist = new ArrayList<String>();

		public User(String name, String pw) {
			this.name = name;
			this.password = pw;

			this.point = 0;

		}
		
		//user의 userlist의 객체가 늘어날때마다 point++

		//user가 refound로 영화 예매를 취소하면 point--

		private void updatePoint() {
			int newSize = reslist.size();

			/* reslist의 크기가 증가하면 point +1
			 * reslist의 크기가 감소하면 point -1
			 * 
			 * 포인트를 써서 결제할 시 쓴 point만큼 감소
			 */
			point = adjustPointOnResize(reslist, point, newSize);
			adjustListSize(reslist, newSize);
		}

		// 리스트 크기 조정 함수
		public static void adjustListSize(ArrayList<Integer> list, int newSize) {
			int currentSize = list.size();

			if (newSize > currentSize) {
				for (int i = currentSize; i < newSize; i++) {
					list.add(0);
				}
			} else if (newSize < currentSize) {
				for (int i = currentSize - 1; i >= newSize; i--) {
					list.remove(i);
				}
			}
		}

		public static int adjustPointOnResize(ArrayList<Integer> list, int point, int newSize) {
			int oldSize = list.size();
			if (oldSize == 0) {
				return 0;
			}
			return (int) ((double) point / oldSize * newSize);
		}
	}
}