package service.LoginService;

import DAO.loginDAO.LoginDAO;

public class LoginService {
	private LoginDAO dao;
	
	public LoginService() {
		dao = new LoginDAO();
	}
	
	//단위기능1. 개인회원 로그인
	public int serviceIlogin(String id, String pwd) {
		return dao.ilogin(id,pwd);
	}
	
	//단위기능2. 회원의 관리자 여부확인
	public int serviceAdmincheck(String id) {
		return dao.adminCheck(id);
	}
	
	//단위기능3. 기업회원 로그인
	public int serviceClogin(String cno,String cPwd) {
		return dao.clogin(cno,cPwd);
	}
	
}
