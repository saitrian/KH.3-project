package sjk.sample_2.teamProject.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleVO {
	private int sd_num;
	private Date sd_time; // 상영 시작 시간
	private Date sd_date; // 상영 시작 날짜
	private int sd_mo_num; 
	private int sd_sc_num;

	public ScheduleVO(Date sdTime, Date sdDate, int sdMoNum, int sdScNum) {
		this.sd_time = sdTime;
		this.sd_date = sdDate;
		this.sd_mo_num = sdMoNum;
		this.sd_sc_num = sdScNum;
	}
}
