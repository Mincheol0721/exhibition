package service.noticeService;

import java.util.ArrayList;

import DAO.noticeDAO.NoticeDAO;

public class NoticeService {
	

	
	public ArrayList getNoticeListSerivce() {
		
		NoticeDAO noticeDAO = new NoticeDAO(); 
		
		return noticeDAO.getNoticeList();
	}
	
//	public NoticeVO getOneNoticeService(int no) {
//		
//		NoticeDAO noticeDAO = new NoticeDAO(); 
//		
//		return noticeDAO.getOneNotice(no);
//		
//	}

}
