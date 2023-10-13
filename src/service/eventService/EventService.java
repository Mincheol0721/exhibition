package service.eventService;

import java.util.List;

import DAO.eventDAO.EventDAO;
import VO.eventVO.EventVO;

public class EventService {
	
	EventDAO dao;
	
	public EventService() {
		dao = new EventDAO();
	}
	
	public List<EventVO> getEventList(int pageNum, int pageSize) {
		
		System.out.println("ser pageNum: " + pageNum);
		List<EventVO> list = dao.getEventList(pageNum, pageSize);
		
		return list;
	}

	public void updateEvent(EventVO vo) {
		dao.updateEvent(vo);
	}

	public void delEvent(int no) {
		dao.delEvent(no);
	}

	public void regEvent(EventVO vo) {
		dao.insertEvent(vo); 
	}
	
	
}
