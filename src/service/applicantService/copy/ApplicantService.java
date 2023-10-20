package service.applicantService.copy;

import java.util.List;

import DAO.applicantDAO.ApplicantDAO;
import VO.applicantVO.ApplicantVO;


public class ApplicantService {
	
	ApplicantDAO dao;
	
	public ApplicantService() {
		dao = new ApplicantDAO();
	}
	
	public List<ApplicantVO> getCList(int pageNum, int pageSize) {
		return dao.getCList(pageNum, pageSize);
	}

	public List<ApplicantVO> getIList(int pageNum, int pageSize) {
		return dao.getIList(pageNum, pageSize);
	}

	public List<ApplicantVO> getMeetings(int pageNum, int pageSize) {
		return dao.getMeetings(pageNum, pageSize);
	}

	
}
