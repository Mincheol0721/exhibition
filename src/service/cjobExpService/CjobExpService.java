package service.cjobExpService;

import java.util.ArrayList;

import DAO.cjobExpDAO.CjobExpDAO;

//부장
public class CjobExpService {
	
	CjobExpDAO cjobExpDAO = new CjobExpDAO();
	
	public ArrayList getcjobExpListSerivce() {
		return cjobExpDAO.getcjobExpList();
	}
}//CjobExpService닫기
