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
	
	public MovieVO(String moTitle, String moContent, int moTime, String moAge, String moDate) {
		this.mo_title = moTitle;
		this.mo_content = moContent;
		this.mo_time = moTime;
		this.mo_age = moAge;
		this.mo_date = moDate;
	}
	
	@Override
	public String toString() {
		return "번호 : "+ mo_num + " / 영화 제목 : " + mo_title + " / 영화 내용 : " + mo_content
				+  " / 영화 상영 시간 : " + mo_date + " / 연령 : " + mo_age +  " / 상영 총 시간 : " + mo_time + "시간";
	}

	public MovieVO(String movieTitle) {
		this.mo_title = movieTitle;
	}
	
	
}
