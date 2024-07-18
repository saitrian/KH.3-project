package teamproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import lombok.Data;
import program.Program;

@Data
public class TicketManager implements Program{
	private Scanner scan = new Scanner(System.in);

	private List<Movie> list = new ArrayList<Movie>();	// 상영중인 영화 리스트
	private List<Movie> bookList = new ArrayList<Movie>(); // 예약 리스트

	/* 추가해야하는 내용 :
	 * 로드/세이브 // DB
	 * 회원가입 / 로그인 시스템 < TreeMap
	 * 	- 포인트 제도 도입
	 * 영화 가격(조조/심야할인, 성인, 청소년, 어린이 요금)
	 * 상영관 좌석 개수 설정
	 * 
	 *	1. 탈주
	 *2. 인사이드아수
	 * 
	 * 번호입력 : 1
	 * 탈주 
	 * 17 18 19
	 * 17
	 * 12~14
	 * 15~17
	 * 
	 * 변경해야하는 내용 :
	 * 영화표 예매(구매)
	 * 	상영중인 영화 리스트 출력
	 * 	영화 선택
	 * 		영화 선택시 해당 영화 시간표 출력 남는 좌석수 함께
	 * 		영화 시간 선택
	 * 		좌석수가 0이면 영화관 남는 좌석이 없다고 출력 후 종료
	 * 		아니면, 구매 진행 
	 * 		조조/심야 시간대 가격 변동
	 * 		회원가입 / 로그인
	 * 			- 회원가입 할 때 나이 적고 로그인하면 등록된 나이 이용해서 요금 결정??
	 * 		구매 시 포인트 사용 여부
	 * 		사용 안하면 포인트 적립
	 * 		좌석수 1 감소
	 * 		구매 완료 출력
	 * 
	 * 영화표 환불	 
	 * 	DB 넣을 때 로그인 저장할 때 해당 ID가 예약한 영화 따로 삭제?
	 * 	포인트 적립했을 시 포인트 회수
	 * 	좌석수 1 증가
	 * 	환불 완료 출력	
	 * 
	 * 영화표 조회
	 *  ID 입력하면 본인 것만 출력?
	 *  
	 * */
	
	@Override
	public void run() {
		addList();
		int menu = 1;
		do {
			printMenu();
			menu = nextInt();
			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != 4);
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1 :
			buyTicket();
			break;
		case 2 :
			refundTicket();
			break;
		case 3 :
			printBookList();
			break;
		case 4 :
			exit();
			break;
		default :
			printBar();
			System.out.println("잘못된 번호 입력입니다");
		}
	}
	
	@Override
	public void printMenu() {
		printBar();
		System.out.print("   【 메뉴 】\r\n"
				+ "1. 영화표 예매\r\n"
				+ "2. 영화표 환불\r\n"
				+ "3. 영화표 조회\r\n"
				+ "4. 프로그램 종료\r\n"
				+ "--------------\r\n"
				+ "메뉴 선택 : ");
	}
	
	private void printBookList() {
		// 예약 전체 조회 
		// 예약 리스트 크기가 0이면 조회할 내역이 없다고 출력하고 리턴
		printBar();
		if( bookList.size() == 0 ) {
			System.out.println("조회할 내역이 없습니다.");
			return;
		}
		// 예약리스트 반복문 이용해서 깔끔하게
		for(int i = 0 ; i < bookList.size() ; i ++) {
			System.out.println(bookList.get(i));				
		}

	}

	private void refundTicket() {
		// 예약 리스트 크기가 0이면 환불할 내역이 없다고 출력하고 리턴
		if( bookList.size() == 0) {
			printBar();
			System.out.println("환불할 내역이 없습니다");
			return;
		}
		// 영화표 예약 목록 출력
		printBar();
		System.out.println(" 【 영화표 예약 목록 】 ");
		// 리스트 번지수 확인 위해서 반복문으로 리스트 출력하면서 옆에 i+1 같이 출력
		for(int i = 0 ;  i < bookList.size() ; i++ ) {
			System.out.println("" + (i+1) + "번 : " + bookList.get(i) );
		}
		// 번호 입력 받기
		System.out.print("번호 입력 : ");
		int deleteNum = scan.nextInt();
		// 0 보다 크거나 예약 리스트 크기랑 같거나 작지 않으면 없는 번호라고 출력
		if( !(0 < deleteNum && deleteNum <= bookList.size())) {
			System.out.println("없는 번호 입니다");
			return;
		}
		// 보기좋게 하기 위해서 i+1 <- 출력했으니 번지수 입력할 때 다시 -1
		bookList.remove(deleteNum-1);
		printBar();
		System.out.println("" + deleteNum + "번 삭제 완료했습니다.");
		return;

	}

	private void buyTicket() {
		int buyMenu;
		do {
			buyMenu = printBuyMenu();
			switch(buyMenu) {
			case 1 :
				nameChoice();
				break;
			case 2 :
				theaterChoice();
				break;
			case 3 :
				timeChoice();
				break;
			case 4:
				break;
			default:
				System.out.println("잘못된 번호 입력입니다");
				break;
			}
		}while( buyMenu != 4 );

	}

	private void timeChoice() {
		movieListPrint();
		// 시간 선택
		scan.nextLine();
		System.out.print("영화 시간 입력 : ");
		String movieTime = scan.nextLine();
		// 영화 리스트에 해당 영화 시간 있는지 확인 후
		int count = 0;
		String str = "";
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getDate().contains(movieTime)) {
				// count 증가시키고, 예약 리스트에 해당 리스트 객체 저장
				count++;
				bookList.add(list.get(i));
				str = list.get(i).getMovieName();
			}
		}
		// count 0 보다 크면, 예약되었습니다 출력
		if(count > 0) {
			printBar();
			System.out.println(str + " 예약되었습니다");
		}
		// 아니면 잘못된 영화 입력
		else {
			printBar();
			System.out.println("잘못된 영화 제목 입력");
		}

	}

	private void theaterChoice() {
		movieListPrint();
		// 상영관 선택
		scan.nextLine();
		System.out.print("상영관 입력 : ");
		String movieTheater = scan.next();
		// 영화 리스트에 상영관 있는지 확인 후
		int count = 0;
		String str = "";
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getTheater().contains(movieTheater)) {
				// count 증가시키고, 예약 리스트에 해당 리스트 객체 저장
				count++;
				bookList.add(list.get(i));
				str = list.get(i).getMovieName();
			}
		}
		// count 0 보다 크면, 예약되었습니다 출력
		if(count > 0) {
			printBar();
			System.out.println(str + " 예약되었습니다");
		}
		// 아니면 잘못된 상영관 입력 출력
		else {
			printBar();
			System.out.println("잘못된 상영관 입력");
		}

	}

	private void nameChoice() {
		movieListPrint();
		// 이름 선택
		scan.nextLine();
		System.out.print("영화 제목 입력 : ");
		String movieName = scan.nextLine();
		// 영화 리스트에 이름 있는지 확인하기 위해 반복문으로 입력받은 movieName 을 포함하는 객체를 찾아서
		int count = 0;
		// 예약 되었을 시에 출력할 String 선언
		String str = "";
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getMovieName().contains(movieName)) {
				// count 증가시키고, 예약 리스트에 해당 리스트 객체 저장
				count++;
				bookList.add(list.get(i));
				str = list.get(i).getMovieName();
			}
		}
		// count 0 보다 크면, 예약되었습니다 출력
		if(count > 0) {
			printBar();
			System.out.println( str + " 예약되었습니다");
		}
		// 아니면 잘못된 영화 입력
		else {
			printBar();
			System.out.println("잘못된 영화 제목 입력");
		}

	}

	private void movieListPrint() {
		// 상영중인 영화 리스트 출력
		printBar();
		System.out.println(" 【 상영중인 영화 목록 】 ");
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));						
		}

	}

	private void exit() {
		printBar();
		System.out.println("프로그램을 종료합니다 :)");

	}

	private int printBuyMenu() {
		printBar();
		System.out.print("【 영화표 예매 】\r\n"
				+ "1. 영화 이름 선택\r\n"
				+ "2. 영화 상영관 선택\r\n"
				+ "3. 영화 시간 선택\r\n"
				+ "4. 이전 메뉴\r\n"
				+ "--------------\r\n"
				+ "메뉴 선택 : ");
		int buyMenu = nextInt();
		return buyMenu;
	}

	public int nextInt() {
		try {
			return scan.nextInt();
		}catch(InputMismatchException e) {
			scan.nextLine();
			return Integer.MIN_VALUE;
		}
	}

	public void printBar() {
		System.out.println("--------------");
	}
	
	public void addList() {
		Movie movie1 = new Movie("인사이드아웃2", "1관", "12:00 ~ 13:00");
		Movie movie2 = new Movie("탈주", "2관", "13:30 ~ 14:30");
		Movie movie3 = new Movie("핸섬가이즈", "3관", "15:00 ~ 16:00");
		Movie movie4 = new Movie("하이재킹", "4관", "17:00 ~ 18:00");
		Movie movie5 = new Movie("이매큘레이트", "5관", "19:00 ~ 20:00");
		list.add(movie1);
		list.add(movie2);
		list.add(movie3);
		list.add(movie4);
		list.add(movie5);
	}
}
