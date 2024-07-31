package sjk.sample_2.teamProject.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieVO {
	
	private int mo_num;
	private String mo_title;
	private String mo_content;
	private int mo_time;
	private String mo_age;
	private String mo_date;
	
	public MovieVO(String moTitle, String moContent, int moTime, String moAge, String moDate) {
		this.mo_title = moTitle;
		this.mo_content = moContent;
		this.mo_time = moTime;
		this.mo_age = moAge;
		this.mo_date = moDate;
	}
}
