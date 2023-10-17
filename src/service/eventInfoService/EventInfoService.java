package service.eventInfoService;

import java.util.ArrayList;

import DAO.eventInfoDAO.EventInfoDAO;

public class EventInfoService {
	
	EventInfoDAO dao;
	
	public EventInfoService() { 
		
		dao = new EventInfoDAO();
		
	}
	
	public void getEventInfo(String name) { 
		
		dao.getEventInfo(name);
		
	}
	
	public void getEventInfoList() {
		
		dao.getEventInfoList();
	}
}
