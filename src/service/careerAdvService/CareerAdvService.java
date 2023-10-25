package service.careerAdvService;

import java.util.ArrayList;

import DAO.careerAdvDAO.careerAdvDAO;

public class CareerAdvService {
		careerAdvDAO careerAdvDAO = new careerAdvDAO();
	//모든 직업체험 조회
		public ArrayList careerAdvListSerivce() {
			
			
			
			return careerAdvDAO.getcareerAdvList();
		}
}
