package teamProject.service;

import teamProject.model.vo.TicketVO;

public interface TicketService {

	boolean insertTicket(String inputId, int movieNum);

	TicketVO selectTicket(String id);
	
}
