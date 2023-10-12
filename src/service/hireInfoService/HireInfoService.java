package service.hireInfoService;

import DAO.hireInfoDAO.HireInfoDAO;
import VO.hireInfoVO.HireInfoVO;

public class HireInfoService {
	private HireInfoDAO dao;
	
	public HireInfoService() {
		dao = new HireInfoDAO();
	}
	
	public void regHireInfo(HireInfoVO vo) {
		dao.insertHireInfo(vo);
	}
	
}
