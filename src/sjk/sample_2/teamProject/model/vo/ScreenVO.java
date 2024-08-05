package sjk.sample_2.teamProject.model.vo;

public class ScreenVO {
	private int sc_num;
	private String sc_name;
	private int sc_seat; 
	private String sc_th_name;
	
	
	public ScreenVO(String name, int seat, String th_name) {
		this.sc_name = name;
		this.sc_seat = seat;
		this.sc_th_name = th_name;
	}
}
