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

	public HireInfoVO getHireInfo(String cname) {
		HireInfoVO vo = dao.getHireInfo(cname);
		return vo;
	}

	public void updateHireInfo(HireInfoVO vo) {
		dao.updateHireInfo(vo);
	}

	public void delHireInfo(String cname) {
		dao.delHireInfo(cname);
	}
}
