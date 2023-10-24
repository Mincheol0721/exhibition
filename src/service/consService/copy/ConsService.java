package service.consService.copy;

import java.util.ArrayList;

import DAO.JobExpDAO.JobExpDAO;
import DAO.consDAO.consDAO;
import VO.JobExpVO.CJobExpVO;
import VO.JobExpVO.IJobExpVO;

//부장
public class ConsService {
	
	consDAO consDAO = new consDAO();
	
	//자소서 컨설팅체험 조회
	public ArrayList getIntroConsListSerivce() {
		return consDAO.getConsList();
	}
	
	//면접 컨설팅체험 조회
		public ArrayList getMeetConsListSerivce() {
			return consDAO.getConsList();
		}
		/*
	//등록한 신청자 데이터 디비에 넣는 기능
	public int insertIjobExpSerivce(IJobExpVO iJobExpVO) {
		
		return jobExpDAO.insertIjobExp(iJobExpVO);
	}
	
*/
	
}//CjobExpService닫기
