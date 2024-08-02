package sjk.sample_2.teamProject.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScreenVO {
	private int sc_num;
	private String sc_name;
	private int sc_seat; 
	private int sc_th_num;
	
	public ScreenVO(String name, int seat, int th_num) {
		this.sc_name = name;
		this.sc_seat = seat;
		this.sc_th_num = th_num;
	}
}