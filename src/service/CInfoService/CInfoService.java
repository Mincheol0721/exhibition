package service.CInfoService;

import java.util.List;

import DAO.CInfoDAO.CInfoDAO;
import VO.CMemberVO.CMemberVO;

public class CInfoService {

	CInfoDAO dao;
	
	public CInfoService() {
		
		dao = new CInfoDAO();
	}
	
	
	public List<CMemberVO> getCInfoList() {
		
		return dao.getCInfoList(); 
	}

}
