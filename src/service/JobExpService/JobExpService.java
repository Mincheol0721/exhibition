package service.JobExpService;

import java.util.ArrayList;

import DAO.JobExpDAO.JobExpDAO;
import VO.JobExpVO.CJobExpVO;
import VO.JobExpVO.IJobExpVO;

//부장
public class JobExpService {
	
	JobExpDAO jobExpDAO = new JobExpDAO();
	
	//모든 직업체험 조회
	public ArrayList getcjobExpListSerivce() {
		return jobExpDAO.getcjobExpList();
	}
	//등록한 신청자 데이터 디비에 넣는 기능
	public int insertIjobExpSerivce(IJobExpVO iJobExpVO) {
		
		return jobExpDAO.insertIjobExp(iJobExpVO);
	}
	
	//등록한 기업 데이터 디비에 넣는 기능
	public int insertCjobExpSerivce(CJobExpVO cJobExpVO) {
			
			return jobExpDAO.insertCjobExp(cJobExpVO);
		}
	
}//CjobExpService닫기
