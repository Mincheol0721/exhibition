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

	public List<ApplicantVO> getConsList(int pageNum, int pageSize, String constype) {
		return dao.getConsList(pageNum, pageSize, constype); 
	}

	public ApplicantVO getCons(int no) {
		return dao.getCons(no);
	}

	public void delCons(int no) {
		dao.delCons(no);
		
	}

	public void modCons(ApplicantVO vo, int no) {
		dao.updateCons(vo, no);
		
	}

	public ApplicantVO getMeeting(int no) {
		return dao.getCons(no);
	}
	
}
