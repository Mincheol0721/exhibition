package service.memberInfoService;

import DAO.memberInfoDAO.MemberInfoDAO;
import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;

public class MemberInfoService {
	
	private MemberInfoDAO dao;
	
	public MemberInfoService() {
		dao = new MemberInfoDAO();
	}
	//단위기능1. 개인회원 개인정보 조회
	public IMemberVO serviceSearchMyInfo(String id) {
		
		return dao.searchMyInfo(id);
		
	}
	//단위기능2. 개인회원 수정 기능
	public int serviceModifyMyInfo(IMemberVO vo,String id) {
		
		return dao.modifyMyInfo(vo,id);
	}
	//단위기능3. 기업회원 개인정보 조회
	public CMemberVO serviceSearchCInfo(String cno) {
		
		return dao.searchCInfo(cno);
	}
	//단위기능4. 기업회원 수정기능
	public int serviceModifyCInfo(CMemberVO vo, String cno) {
		
		return dao.modifyCInfo(vo,cno);
	}

}
