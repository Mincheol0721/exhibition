package service.JobExpService;

import java.util.ArrayList;

import DAO.JobExpDAO.JobExpDAO;
import VO.JobExpVO.CJobExpVO;
import VO.JobExpVO.IJobExpVO;

//부장
public class JobExpService {
	
	JobExpDAO jobExpDAO = new JobExpDAO();
	
	public ArrayList getcjobExpListSerivce() {
		return jobExpDAO.getcjobExpList();
	}
	
	public int insertIjobExpSerivce(IJobExpVO iJobExpVO) {
		
		return jobExpDAO.insertIjobExp(iJobExpVO);
	}
	
	public int insertCjobExpSerivce(CJobExpVO cJobExpVO) {
			
			return jobExpDAO.insertCjobExp(cJobExpVO);
		}
	
}//CjobExpService닫기
