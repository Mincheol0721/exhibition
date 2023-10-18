package service.JobExpService;

import java.util.ArrayList;

import DAO.JobExpDAO.JobExpDAO;

//부장
public class JobExpService {
	
	JobExpDAO cjobExpDAO = new JobExpDAO();
	
	public ArrayList getcjobExpListSerivce() {
		return cjobExpDAO.getcjobExpList();
	}
}//CjobExpService닫기
