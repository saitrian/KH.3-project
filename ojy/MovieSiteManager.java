package teamproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class MovieSiteManager implements Program{

	private Scanner scan = new Scanner(System.in);

	private final int RESERVE = 1;
	private final int CANCEL = 2;
	private final int CHECK = 3;
	private final int EXIT = 4;
	
	private final int SEARCHMOVIE = 1;
	private final int SEARCHTHEATER = 2;
	private final int SEARCHTIME = 3;
	private final int PREV = 4;


	private String fileName = "src/teamproject/reserveList.txt";
	//영화 목록 리스트
	private List<Integer> listnnn = new ArrayList<Integer>();
	private Integer n1 = 1;
	
	private List<MovieList> list = new ArrayList<MovieList>();
	MovieList ml1 = new MovieList("어벤져스", "1관", "2020-01-01");
	MovieList ml2 = new MovieList("파묘", "1관", "2020-01-02");
	MovieList ml3 = new MovieList("명량", "2관", "2020-02-01");
	MovieList ml4 = new MovieList("미니언즈", "3관", "2020-02-02");
	
	//영화 예매 리스트
	private List<String> reslist = new ArrayList<String>();
	
	private String movieList = "src/teamproject/movieList.txt";
	//예약 리스트
	private String resList = "src/teamproject/reserveList.txt";
	

	@Override
	public void printMenu() {
		System.out.print(
				"메뉴\r\n"
						+"1. 영화 예매(구매)\r\n"
						+"2. 영화표 환불\r\n"
						+"3. 영화표 조회\r\n"
						+"4. 프로그램 종료\r\n"
						+"메뉴 선택 : ");
	}

	@Override
	public void run() {
		int menu;
		load(resList);
		load(movieList);
		
		list.add(new MovieList("어벤져스", "1관", "2020-01-01"));
		list.add(ml2);
		do {
			printMenu();

			menu = nextInt();
			printLine();

			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != EXIT);
		save(resList);
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case RESERVE:
			reserve();
			break;
		case CHECK:
			check();
		case CANCEL:
			cancel();
		case EXIT:
			exit();
			break;
		default:
		}
	}

	private void reserve() {
		int menu = SEARCHMOVIE;
		do {
			try {
				printReserveMenu();
				menu = nextInt();
				
				printLine();
				runReserveMenu(menu);
			}
			catch(InputMismatchException e) {
				printLine();
				System.out.println("올바른 메뉴를 입력하세요.");
				scan.nextLine();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}while(menu != PREV);

	}

	private void printReserveMenu() {
		System.out.print(
				"메뉴\r\n"
						+"1. 영화 이름 검색\r\n"
						+"2. 영화 상영관 검색\r\n"
						+"3. 영화 시간 검색\r\n"
						+"4. 이전으로\r\n"
						+"메뉴 선택 : ");
	}

	private void runReserveMenu(int menu) {
		switch(menu) {
		case SEARCHMOVIE:
			searchmovie();
			break;
		case SEARCHTHEATER:
			searchtheater();
			break;
		case SEARCHTIME:
			searchtime();
			break;
		case PREV:
			prev();
			break;
		default:
		}
	}

	/*
	 * 1. movieList의 모든 값들을 출력한다.
	 * 2. 번호를 입력받는다.
	 * 3. 입력받은 번호에 맞는 movieList에 있는 값을 어딘가에 저장한다.
	 */
	private void searchmovie() {
		System.out.print("영화 이름 검색 : ");
		scan.nextLine();
		String movieName = scan.nextLine();
		for(int i = 0; i < movieList.length(); i++) {
			if(movieName.equals(list.get(i))) {
				System.out.println(i+1 + ". " + list.get(i));
			}
			System.out.print("예약하실 영화의 번호를 입력해주세요 : ");
			int reserveNum = scan.nextInt();
			if(reserveNum == i) {
				reslist = list.get(i);
			}
		}
	}

	private void searchtheater() {
		System.out.print("영화 상영관 검색 : ");
		String theaterNum = scan. next();
		for(int i = 0; i < movieList.length(); i++) {
			if(theaterNum.equals(list.get(i))) {
				System.out.println(i+1 + ". " + list.get(i));
			}
		}
	}

	private void searchtime() {
		System.out.print("영화 시간 검색 : ");
		String movieTime = scan.next();
		for(int i = 0; i < movieList.length(); i++) {
			if(movieTime.equals(list.get(i))) {
				System.out.println(i+1 + ". " + list.get(i));
			}
		}
	}

	private void prev() {
		System.out.println("이전으로 돌어갑니다.");
		printLine();
	}

	private void check() {
		for (int i = 0; i < resList.length(); i++) {
            System.out.println((i + 1) + ". " + resList.indexOf(i));
        }
	}

	private void cancel() {
		for (int i = 0; i < resList.length(); i++) {
            System.out.println((i + 1) + ". " + resList.indexOf(i));
        }
		System.out.print("취소할 영화의 번호를 입력해주세요 : ");
		int cancelNum = scan.nextInt();
		
		for (int i = 0; i < resList.length(); i++) {
            if(cancelNum == (i+1)) {
            	resList.remove();
            	 System.out.println("취소가 완료되었습니다.");
            }
            else {
            	System.out.println("잘못된 입력입니다.");
            }
        }
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	@Override
	public void save(String movieList) {
		try(FileOutputStream fos = new FileOutputStream(movieList);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
			oos.writeObject(reslist);
		} catch (Exception e) {
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String movieList) {
		try(FileInputStream fis = new FileInputStream(movieList);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<MovieList>)ois.readObject();
			reslist = (List<String>)ois.readObject();
		} catch (Exception e) {
		}
	}


	public int nextInt() {
		try {
			return scan.nextInt();
		}catch(InputMismatchException e) {
			scan.nextLine();
			return Integer.MIN_VALUE;
		}
	}

	private void printLine() {
		System.out.println("---------------");

	}

}
