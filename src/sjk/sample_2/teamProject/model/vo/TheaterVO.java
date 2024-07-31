package sjk.sample_2.teamProject.model.vo;

public class TheaterVO {

	private int th_num;
	private String th_name;
	private int th_screen;
	private int th_seat;
	private String th_address;
	private String th_region;
	public TheaterVO(String th_name2, int th_screen2, int th_seat2, String th_address2, String th_region2) {
		this.th_name = th_name2;
		this.th_screen = th_screen2;
		this.th_seat = th_seat2;
		this.th_address = th_address2;
		this.th_region = th_region2;
	}
}
