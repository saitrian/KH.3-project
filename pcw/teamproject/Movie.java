package teamproject;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
		private String movieName;
		private String theater;
		private String date;
		
		
		@Override
		public String toString() {
			return "제목 : " + movieName + ", 상영관 : " + theater + ", 날짜 : " + date;
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
			return Objects.equals(date, other.date) && Objects.equals(movieName, other.movieName)
					&& Objects.equals(theater, other.theater);
		}

		@Override
		public int hashCode() {
			return Objects.hash(date, movieName, theater);
		}

		
	
	}
