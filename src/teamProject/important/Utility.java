package teamProject.important;

import java.util.Scanner;

public class Utility {
    private static Utility instance;
	//콘솔에서 입력을 받기 위한 스캐너 메서드
	public Scanner scan = new Scanner(System.in);

    private Utility() {
    }
    //인스탄스 생성
    public static Utility getInstance() {
    	//만약 인스턴스가 없으면 새로 생성
        if (instance == null) {
        	instance = new Utility();
        }
        
        return instance;
    }
    //절취선
	public void printDottedLine() {
		System.out.println("--------------------");
	}
}
