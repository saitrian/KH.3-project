package sjk.sample_1.kiosk;

public class MovieInfo {
	private String name;
	
	public MovieInfo(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
