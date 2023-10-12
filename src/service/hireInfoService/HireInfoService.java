package service.hireInfoService;

import java.util.List;

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
	
	public List<HireInfoVO> getHireInfoList(int pageNum, int pageSize) {
		System.out.println("service");
		List<HireInfoVO> list = dao.getHireInfoList(pageNum, pageSize);
		
		return list;
	}
}
