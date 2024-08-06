package teamProject.service;

import teamProject.model.vo.ScreenVO;

public interface ScreenService {

	boolean insertScreen(ScreenVO screen);

	ScreenVO selectScreen(String screenName);

}
