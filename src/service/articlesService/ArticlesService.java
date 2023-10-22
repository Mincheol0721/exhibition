package service.articlesService;

import java.util.List;

import DAO.newsLettersDAO.NewsLettersDAO;
import VO.newsLettersVO.NewsLettersVO;

public class ArticlesService {
	
	NewsLettersDAO dao;
	
	public ArticlesService() {
		
		dao = new NewsLettersDAO();
	}
	
	public void insertNewsLetters(NewsLettersVO vo) {
		
		dao.insertNewsLetters(vo); 
	}

	public List<NewsLettersVO> getBoardList(int startRow, int pageSize) {
		
		return dao.getBoardList(startRow, pageSize);
	}

	public NewsLettersVO getNewsLettersDetail(int no) {
		
		return dao.getNewsLettersDetail(no);
	}
	
}
