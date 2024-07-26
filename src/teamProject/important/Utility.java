package teamProject.important;

import java.util.Scanner;

public class Utility {
    private static Utility instance;
	
	public Scanner scan = new Scanner(System.in);

    private Utility() {
    }
    
    public static Utility getInstance() {
        if (instance == null) {
        	instance = new Utility();
        }
        
        return instance;
    }
    
	public void printDottedLine() {
		System.out.println("--------------------");
	}
	
	/*	기능 : 랜덤한 4자리의 수를 생성해주는 메서드
	 * 	@return : 예매번호(랜덤 4자리)
	 * */
	public String getRandomNumber() {
		// 랜덤한 수 1 ~ 9999까지 생성해주는 코드
		int min = 1, max = 9999,	
			randomNumber = (int)(Math.random() * (max - min + 1) + min);
		// 만약에 1이면 0001 로 보이게 출력해주는 코드
		return String.format("%04d", randomNumber);
	}
}
