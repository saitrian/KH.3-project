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
}
