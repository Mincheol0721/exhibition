package VO.newsLettersVO;

import java.sql.Date;

public class NewsLettersVO {
	
    int no; 				// 글번호
    String title; 			// 글 제목
    String content;			// 글 내용
    String fileName;		// 첨부이미지파일 이름
    String fileRealName;	// 첨부이미지파일 실제이름
    Date writeDate;			// 글 작성일
    int readCount; 			// 글 조회수(기본값 0)
    
    public NewsLettersVO() {
		
	}

	public NewsLettersVO(int no, String title, String content, String fileName, String fileRealName,
			Date writeDate, int readCount) {

		this.no = no;
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
