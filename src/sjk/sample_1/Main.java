package sjk.sample_1;

import sjk.sample_1.kiosk.DataBase;
import sjk.sample_1.kiosk.MovieKiosk;

public class Main {
	public static void main(String[] args) {
		DataBase db = new DataBase();

		MovieKiosk kiosk = new MovieKiosk();

		kiosk.connectDB(db);
		kiosk.excute();
	}
}