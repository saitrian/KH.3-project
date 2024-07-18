package main;

import sjk.DataBase;
import sjk.MovieKiosk;

public class Main {
	public static void main(String[] args) {
		DataBase db = new DataBase();

		MovieKiosk kiosk = new MovieKiosk();

		kiosk.connectDB(db);
		kiosk.excute();
	}
}