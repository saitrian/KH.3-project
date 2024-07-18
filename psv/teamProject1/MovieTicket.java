package teamProject1;

import java.util.ArrayList;
import java.util.List;

public class MovieTicket {
	private List<Movie> movies; // 영화 목록
	 
	// 생성자
    public MovieTicket() {
        this.movies = new ArrayList<>();
    }
    

	public void addMovie(String movieName, String movieTheater, String movieDate) {
        movies.add(new Movie(movieName, movieTheater, movieDate));
    }
	
	// 영화 목록 표시
    public void showMovies() {
        if (movies.isEmpty()) {
            System.out.println("현재 상영 중인 영화가 없습니다.");
        } else {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }
    
    public boolean movieTicketing(String movieName){
    	for(Movie movies : movies) {
    		System.out.println(movies);
			if(movies.getMovieName().contains(movieName)) {
				System.out.println("[" + movieName + "]를 선택하셨습니다.");
				return true;
			}else {
				System.err.println("선택하신 영화는 현재 상영작이 아닙니다.");
				return false;
			}
		}
        System.out.println(movieName + " 영화를 찾을 수 없습니다.");
		return false;
    }
	
}
