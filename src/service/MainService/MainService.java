package service.MainService;

import DAO.eventInfoDAO.EventInfoDAO;

public class MainService {

	EventInfoDAO dao;
	
	public MainService() { 
		
		dao = new EventInfoDAO();
		
	}
	
}
