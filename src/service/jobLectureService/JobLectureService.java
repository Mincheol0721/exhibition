package service.jobLectureService;

import java.util.ArrayList;

import DAO.JobExpDAO.JobExpDAO;
import DAO.consDAO.consDAO;
import DAO.jobLectureDAO.JobLectureDAO;
import VO.JobExpVO.CJobExpVO;
import VO.JobExpVO.IJobExpVO;

//부장
public class JobLectureService {
	
	JobLectureDAO jobLectureDAO = new JobLectureDAO();
	
	//모든 직업특강 조회
	public ArrayList getJobLectureListSerivce() {
		return jobLectureDAO.getJobLectureList();
	}
	
	

	

	
}//CjobExpService닫기
