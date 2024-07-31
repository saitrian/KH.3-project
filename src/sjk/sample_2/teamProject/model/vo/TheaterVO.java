package sjk.sample_2.teamProject.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TheaterVO {
	private int th_num; 
	private String th_name; 
	private int th_screen; 
	private int th_seat; 
	private String th_address; 
	private String th_region;
	
	public TheaterVO(String th_name, int th_screen, int th_seat, String th_address, String th_region) {
		super();
		this.th_name = th_name;
		this.th_screen = th_screen;
		this.th_seat = th_seat;
		this.th_address = th_address;
		this.th_region = th_region;
	}	
}
