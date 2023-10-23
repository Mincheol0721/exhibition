package service.eventInfoService;

import java.util.ArrayList;
import java.util.List;

import DAO.eventInfoDAO.EventInfoDAO;
import VO.eventInfoVO.EventInfoVO;

public class EventInfoService {
	
	EventInfoDAO dao;
	
	public EventInfoService() { 
		
		dao = new EventInfoDAO();
		
	}
	
	public EventInfoVO getEventInfo(int no) { 
		
		return dao.getEventInfo(no);
		
	}
	
	public List<EventInfoVO> getEventInfoList() {
		
		return dao.getEventInfoList();
	}
}
