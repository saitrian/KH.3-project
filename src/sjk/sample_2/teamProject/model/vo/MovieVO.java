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
	
	public MovieVO(String mo_title, String mo_content, int mo_time, String mo_age, String mo_date) {
		super();
		this.mo_title = mo_title;
		this.mo_content = mo_content;
		this.mo_time = mo_time;
		this.mo_age = mo_age;
		this.mo_date = mo_date;
	}

	@Override
	public String toString() {
		return mo_title + "(" + mo_age + ") : " + mo_time + " 분";
	}
}
