package service.noticeService;

import java.util.ArrayList;

import DAO.noticeDAO.NoticeDAO;
import VO.noticeVO.NoticeVO;

public class NoticeService {
	

	//단위기능 1. 모든 행의 데이터를 조회
	public ArrayList getNoticeListSerivce() {
		
		NoticeDAO noticeDAO = new NoticeDAO(); 
		
		return noticeDAO.getNoticeList();
	}
	//단위기능 2. 한 행의 데이터만 조회
	public NoticeVO getOneNoticeService(int no) {
		
		NoticeDAO noticeDAO = new NoticeDAO(); 
		
		return noticeDAO.getOneNotice(no);
		
	}
	
	//단위기능 3. 조회수 증가
	public void plusReadCountService(int no) {
			
			NoticeDAO noticeDAO = new NoticeDAO(); 
			
			 noticeDAO.plusReadCount(no);
			
	}

}
