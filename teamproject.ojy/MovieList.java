package teamproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieList implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*영화의 이름, 날짜*/
	private String name, theater, date;
	
	private List<MovieList> movieList = new ArrayList<MovieList>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieList other = (MovieList) obj;
		return name == other.name && theater == other.theater && date == other.date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, date);
	}

	public MovieList(String name, String theater, String date) {
		this.name = name;
		this.theater = theater;
		this.date = date;
	}

	public void print() {
		System.out.println("영화 이름 : " + name + "상영관 : " + theater +"상영 시간 : " + date);
		if(movieList.size() == 0) {
			System.out.println("등록된 영화가 없습니다.");
			return;
		}
		for(MovieList tmp : movieList) {
			System.out.println(tmp);
		}
		
	}

	public void update(MovieList ml) {
		this.name = ml.name;
		this.theater = ml.theater;
		this.date = ml.date;
	}
}
