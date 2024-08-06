package sjk.sample_2.teamProject.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieVO {
	
	private int mo_num; // 영화 번호
	private String mo_title; // 제목
	private String mo_content; // 내용
	private int mo_time; // 시간
	private String mo_age; // 연령
	private String mo_date; // 개봉일
	
	private String sd_date;
	private String sd_time;
	private String sc_name;
	private String th_name;
	
	public MovieVO(String moTitle, String moContent, int moTime, String moAge, String moDate) {
		this.mo_title = moTitle;
		this.mo_content = moContent;
		this.mo_time = moTime;
		this.mo_age = moAge;
		this.mo_date = moDate;
	}
	
	@Override
	public String toString() {
		return "제목 : " + mo_title + " / 상영일 : " + sd_date + " " + sd_time 
				+ " / 상영관 : " + sc_name + " / 영화관 : " + th_name;
	}

	public MovieVO(String mo_title) {
		this.mo_title = mo_title;
	}
	
}
