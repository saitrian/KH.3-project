package sjk.sample_2.teamProject.service;

import sjk.sample_2.teamProject.model.vo.TicketVO;

public interface TicketService {

	boolean insertTicket(String inputId, int movieNum);

	TicketVO selectTicket(String id);
	
}
