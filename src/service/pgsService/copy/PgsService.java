package service.pgsService.copy;

import java.util.List;

import DAO.pgsDAO.PgsDAO;
import VO.pgsVO.PgsVO;

public class PgsService {
	
	PgsDAO dao;
	
	public PgsService() {
		dao = new PgsDAO();
	}
	
	public List<PgsVO> getPgsList(int pageNum, int pageSize) {
		
		System.out.println("ser pageNum: " + pageNum);
		List<PgsVO> list = dao.getPgsList(pageNum, pageSize);
		
		return list;
	}

	public PgsVO getPgs(int pno) {
		return dao.getPgs(pno); 
	}

	public void updatePgs(PgsVO vo) {
		dao.updatePgs(vo);
	}

	public void regPgs(PgsVO vo) {
		dao.regPgs(vo);
	}

	public void delPgs(int pno) {
		dao.delPgs(pno);
	}

	
}
