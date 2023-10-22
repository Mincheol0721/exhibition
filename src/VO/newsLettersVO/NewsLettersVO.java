package VO.newsLettersVO;

import java.sql.Date;

public class NewsLettersVO {
	
    int no; 				// 글번호
    String articleType;		// 글 유형(공지사항 / 뉴스)
    String title; 			// 글 제목
    String content;			// 글 내용
    String fileName;		// 첨부이미지파일 이름
    String fileRealName;	// 첨부이미지파일 실제이름
    int re_ref; 			// 부모글과 자식글들이 값은 값을 가지기 위한 필드
    int re_lev; 			// 같은 group 내 들여쓰기
    int re_seq; 			// 같은 group 내 순서
    Date writeDate;			// 글 작성일
    int readCount; 			// 글 조회수(기본값 0)
    
    public NewsLettersVO() {
		
	}

	public NewsLettersVO(int no, String articleType, String title, String content, String fileName, String fileRealName,
			int re_ref, int re_lev, int re_seq, Date writeDate, int readCount) {

		this.no = no;
		this.articleType = articleType;
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.re_ref = re_ref;
		this.re_lev = re_lev;
		this.re_seq = re_seq;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileRealName() {
		return fileRealName;
	}

	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}

	public int getRe_ref() {
		return re_ref;
	}

	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}

	public int getRe_lev() {
		return re_lev;
	}

	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}

	public int getRe_seq() {
		return re_seq;
	}

	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	
	
	
}
