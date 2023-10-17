package service.eventInfoService;

import DAO.eventInfoDAO.EventInfoDAO;

public class EventInfoService {
	
	EventInfoDAO dao;
	
	public EventInfoService() { 
		
		dao = new EventInfoDAO();
		
	}
	
	public void getEventInfo(int no) { 
		
		dao.getEventInfo(no);
		
	}
}
