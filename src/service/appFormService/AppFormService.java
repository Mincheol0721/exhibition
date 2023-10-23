package service.appFormService;

import java.util.List;

import DAO.appFormDAO.AppFormDAO;
import VO.IMemberVO.IMemberVO;
import VO.appFormVO.AppFormVO;

public class AppFormService {
	
	AppFormDAO dao;
	
	public AppFormService() {
		dao = new AppFormDAO();
	}
	
	public List<AppFormVO> getAppFormList(int pageNum, int pageSize, String cname) {
		
		System.out.println("ser pageNum: " + pageNum);
		List<AppFormVO> list = dao.getAppFormList(pageNum, pageSize, cname);
		
		return list;
	}

	public AppFormVO getAppForm(String ssn) {
		return dao.getAppForm(ssn);
	}

	public List<AppFormVO> getCareerExp(String ssn) {
		return dao.getCareerExp(ssn);
	}

	public List<AppFormVO> getLicense(String ssn) {
		return dao.getLicense(ssn);
	}

	public List<AppFormVO> getTraining(String ssn) {
		return dao.getTraining(ssn);
	}

	public IMemberVO getImember(String ssn) {
		return dao.getImember(ssn);
	}

	public byte[] getImageBytesFromDatabase(String imageId) {
		return dao.getImageBytesFromDatabase(imageId);
	}

	public void insertAppForm(AppFormVO vo, String id) {
		dao.insertAppForm(vo, id);
	}
	

	
}
