package service.articlesService;

import java.util.List;

import DAO.newsLettersDAO.NewsLettersDAO;
import VO.newsLettersVO.NewsLettersVO;

public class ArticlesService {
	
	NewsLettersDAO dao;
	
	public ArticlesService() {
		
		dao = new NewsLettersDAO();
	}
	
	public void insertNewsLetters(String title, String content, String fileName, String fileRealName) {
		
		dao.insertNewsLetters(title,  content,  fileName,  fileRealName);
	}

	public List<NewsLettersVO> getBoardList(int startRow, int pageSize) {
		
		return dao.getBoardList(startRow, pageSize); 
	}

	public NewsLettersVO getNewsLettersDetail(int no) {
		
		return dao.getNewsLettersDetail(no);
	}
	
	public NewsLettersVO getNewsLetterByNo(int no) {
		
		return dao.getNewsLetterByNo(no);
	}
	
	public void updateNewsLetter(int no, String title, String content) {
		
		dao.updateNewsLetter(no, title, content);
	}
	
	public void delNewsLetters(int no) {
		
		dao.delNewsLetters(no);
	}
	
}
