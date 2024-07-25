package teamProject.important;

import java.util.Scanner;
//좀 더 간결한 사용을 위해 Utility 생성
public class Utility {
    private static Utility instance;
	//콘솔에 값을 입력받기 위한 스캐너 생성
	public Scanner scan = new Scanner(System.in);

    private Utility() {
    }
    //인스턴스 생성
    public static Utility getInstance() {
    	//만약 인스턴스가 없으면 새로운 인스턴스 생성
        if (instance == null) {
        	instance = new Utility();
        }
        
        return instance;
    }
    //절취선 출력
	public void printDottedLine() {
		System.out.println("--------------------");
	}
}
