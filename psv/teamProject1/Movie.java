package teamProject1;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie implements Serializable {
	private static final long serialVersionUID = 8600542066645000464L; // save, load
	
	private String movieName; // 영화 이름
	private String movieTheater; // 영화 상영관
	private String movieDate; // 영화 날짜 및 시간

	@Override
	public String toString() {
		return "영화 이름 : " + movieName + ", 영화 상영관 : " + movieTheater + "관, 영화 날짜 : "
				+ movieDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(movieName, other.movieName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieName);
	}

	
	
}
