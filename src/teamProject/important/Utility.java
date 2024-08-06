package teamProject.important;

public class Utility {
    private static Utility instance;
    
	private String address = "teamProject/config/mybatis-config.xml";

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

	public String getAddress() {
		return address;
	}
}
