package sjk.sample_2.teamProject.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleVO {
	private int sd_num; // 스케쥴 번호
	private String sd_time; // 상영 시작 시간
	private String sd_date; // 상영일
	private int sd_mo_num; // 영화 번호
	private int sd_sc_num; // 상영관 번호

	public ScheduleVO(String sd_time, String sd_date, int sd_mo_num, int sd_sc_num) {
		this.sd_time = sd_time;
		this.sd_date = sd_date;
		this.sd_mo_num = sd_mo_num;
		this.sd_sc_num = sd_sc_num;
	}
	
	/*
	public String getSd_date() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(sd_time);
	}
	
	public String getSd_time() {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		return format.format(sd_date);
	}
	*/
	
	@Override
	public String toString() {
		return "상영 날짜 : " + sd_date + " " + sd_time
				+ " / 상영관 : " + sd_sc_num;
	}
	
	
}
