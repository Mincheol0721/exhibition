package service.joinService;


import DAO.joinDAO.JoinDAO;
import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;

public class JoinService {
	
	private JoinDAO dao;
	
	public JoinService () {
		dao = new JoinDAO();
	}
	
	//1.단위기능(개인회원가입)
	public void serviceAddIMember(IMemberVO vo) {
		dao.addIMember(vo);
	}
	
	//2.단위기능(기업회원가입)
	public void serviceAddCMember(CMemberVO vo) {
		dao.addCMember(vo);
	}
	
	//3.단위기능(아이디중복체크)
	public boolean serviceOverLappedId(String id) {
		return dao.overlappedId(id);
	}
	
	//4.단위기능(사업자등록번호 체크)
	public boolean serviceOverLappedCno(String cno) {
		return dao.overlappedCno(cno);
	}

	

	
	
}
