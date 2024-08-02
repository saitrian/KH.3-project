package sjk.sample_2.teamProject.model.vo;

public class TheaterVO {

	private int th_num;
	private String th_name;
	private int th_screen;
	private int th_seat;
	private String th_address;
	private String th_region;
	public TheaterVO(String name, int screen, int seat, String address, String region) {
		this.th_name = name;
		this.th_screen = screen;
		this.th_seat = seat;
		this.th_address = address;
		this.th_region = region;
	}
}
