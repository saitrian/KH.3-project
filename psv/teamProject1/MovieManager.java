package teamProject1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import program.Program;

public class MovieManager implements Program {
	
	private final int TICKETING = 1;
	private final int REFUND = 2;
	private final int CHECK = 3;
	private final int PRODUCE = 4;
	private final int EXIT = 5;
	
	
	private Scanner scan = new Scanner(System.in);
	// private String fileName = "src/teamProject1/movieList.txt";
	
	// 영화 관리를 위한 리스트
	private List<Movie> list = new ArrayList<Movie>();
	
	@Override
	public void printMenu() {
		System.out.print(
				  "-----영화관 메뉴-----\n"
				+ "1. 영화표 예매\n"
				+ "2. 영화표 환불\n"
				+ "3. 영화표 조회\n"
				+ "4. 영화 추가\n"
				+ "5. 프로그램 종료\n"
				+ "메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case TICKETING:
			ticketing();
			break;
		case REFUND:
			refund();
			break;
		case CHECK:
			check();
			break;
		case PRODUCE:
			produce();
			break;
		case EXIT:
			exit();
			break;
		default:
			defaultPrint();
		}
	}


	/**
	 * 기능 : 영화표 예매 기능
	 */
	private void ticketing() {
		/*
		 * TODO 영화표 예매할 수 있는 기능 만들기
		 * 1. 영화표 예매(구매)
		 * 		a. 영화 이름 선택
		 * 		b. 영화 상영관 선택
		 * 		c. 영화 시간 선택
		 */
		
		if(list.size() == 0) {
			System.err.println("현재 상영작이 없습니다.");
			return;
		}
		
		System.out.println("-----현재 상영작 목록-----");
		int i = 0;
		for(Movie tmp : list) {
			i++;
			System.out.println(i + ". 상영관 " + tmp.getMovieTheater() + "관 / "+ tmp.getMovieName() + " / 날짜 : " + tmp.getMovieDate());
		}
		dashPrint();
		
		
		scan.nextLine();
		System.out.print("예매할 영화 번호 선택 : ");
		int movieNum = scan.nextInt();


		// if문 대신 try-catch를 이용한 IndexOutOfBoundsException 예외처리
		/*
		if(movieNum >= 0 && movieNum < list.size()) {
			System.out.println(list.get(movieNum - 1));
		}else {
			System.err.println("잘못된 값을 선택하셨습니다.");
			return;
		}
		*/
		try {
			System.out.println(list.get(movieNum - 1));
			dashPrint();
			System.out.println("예매를 완료 했습니다.");
			dashPrint();
		} catch(IndexOutOfBoundsException e) {
			System.err.println("잘못된 값을 선택하셨습니다.");
		}
		
	}

	/**
	 * 기능 : 영화표 환불 기능
	 */
	private void refund() {
		/*
		 * TODO 영화표 환불 기능 만들기
		 *  1. 예매 목록에서 날짜를 수정할 번호 선택 후 환불 진행
		 *  	a. 한번더 체크하지 않음. 바로 환불.
		 */
		
	}

	/**
	 * 기능 : 영화표 조회 기능
	 */
	private void check() {
		/*
		 * TODO 영화표 전체 조회 기능 만들기
		 *  	a. 회원/비회원이 아니라 전체 조회
		 */
		
		// 찾을 영화 입력
		System.out.print("검색할 영화 제목 입력(전체 검색은 엔터) : ");
		scan.nextLine();
		String search = scan.nextLine();
		
		// 영화 상영작 목록에서 검색어가 제목에 들어간 게시글 리스트를 가져옴
//		List<Movie> searchList = getSearchList(search);
		
		if(list.size() == 0) {
			dashPrint();
			System.err.println("현재 상영작이 없습니다.");
			dashPrint();
			return;
		}
		
		// 현재 list에 저장된 상영작 목록 출력
		int i = 0;
		System.out.println("-----현재 상영작 목록-----");
		for(Movie tmp : list) {
			i++;
			System.out.println(i + ". 상영관 " + tmp.getMovieTheater() + "관 / "+ tmp.getMovieName() + " / 날짜 : " + tmp.getMovieDate());
		}

		// 메뉴로 돌아가려면... 문구 출력
		System.err.print("메뉴로 돌아가려면 엔터를 치세요.");
		
		// 엔터를 입력받도록 처리
		scan.nextLine(); // 게시글 번호 입력할 때 남은 공백처리
		scan.nextLine(); // 입력한 엔터 처리
		
	}
	
	
	/**
	 * 기능 : 검색 기능 메소드
	 * @param search
	 * @return
	 */
//	private List<Movie> getSearchList(String search) {
//		List<Post> searchList = new ArrayList<Post>();
//		// 전체 게시글에서 하나씩 꺼내서 전체 탐색
//		for(Movie searchL : list) {
//			// 게시글에 제목 또는 내용에 검색어가 포함되어 있으면 검색 리스트에 추가
//			if(searchL.getTitle().contains(search)) {
//				searchL.add(search);
//			}
//		}
//		
//		
//		// 스트림을 이용하여 검색어와 일치하는 게시글 리스트를 가져옴
//		/*
//		return postList.stream().filter(p->p.getTitle().contains(search)
//										|| p.getContents().contains(search))
//								.collect(Collectors.toList());
//		*/
//		return search;
//	}
//	

	/**
	 * 기능 : 영화 추가 기능
	 */
	private void produce() {
		System.out.println("영화 추가하기를 선택하셨습니다.");
		System.out.print("영화 이름 추가 : ");
		scan.nextLine();
		String movieName = scan.nextLine();
		System.out.print("영화 상영관 추가 : ");
		String movieTheater = scan.nextLine();
		System.out.print("영화 날짜 추가(2024-07-01 11:11) : ");
		String movieDate = scan.nextLine();

		String regex = "^[\\d]{1,4}-[\\d]{1,2}-[\\d]{1,2}\s[\\d]{1,2}:[\\d]{1,2}$";
		boolean result = Pattern.matches(regex, movieDate);
		if(!result) {
			System.err.println("등록한 일정이 날짜 형식에 맞지 않습니다.");
			return;
		}
		
		Movie movieNameList = new Movie(movieName, movieTheater, movieDate);
		list.add(movieNameList);
		
		System.out.println(movieNameList +"가 추가 됐습니다.");
	}
	
	@Override
	public void run() {
		
		list.add(new Movie("탈주", "1" , "2024-07-01 12:00 ~ 2024-07-01 01:00"));
		list.add(new Movie("인사이드 아웃2", "2" , "2024-07-01 12:00 ~ 2024-07-01 01:00"));
		list.add(new Movie("범죄도시4", "3" , "2024-07-01 12:00 ~ 2024-07-01 01:00"));
		list.add(new Movie("퓨리오사: 매드맥스 사가", "4" , "2024-07-01 12:00 ~ 2024-07-01 01:00"));
		list.add(new Movie("어벤져스", "5" , "2024-07-01 12:00 ~ 2024-07-01 01:00"));
		
		int menu;
		
		//load(fileName);
		
		do {
			printMenu();
			menu = nextInt();
			
			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(menu != EXIT);
		
		// save(fileName);
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void defaultPrint() {
		System.err.println("올바른 메뉴를 선택하세요.");
	}
	
	/**
	 * 
	 */
	public void dashPrint() {
		System.out.println("--------------------");
	}
	
	/**
	 * 기능 : 콘솔에서 정수를 입력 받아 반환하는 메소드로 잘못 입력(문자열) 하면 정수의 가장 작은 수를 반환
	 * @return 사용자가 콘솔에 입력한 정수 또는 정수의 가장 작은 수
	 */
	public int nextInt() {
		try {
			return scan.nextInt();
		} catch(InputMismatchException e) {
			scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에서 비워줌.
			return Integer.MIN_VALUE; // int의 가장 작은 수를 리턴
		}
	}
}
