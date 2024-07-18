package important;

import java.util.Scanner;

public class Utility {
    private static Utility instance;
	
	public final int TICKETING = 1;
	public final int REFUND = 2;
	public final int CHECK = 3;
	public final int PRODUCE = 4;
	public final int EXIT = 5;
	
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
}
