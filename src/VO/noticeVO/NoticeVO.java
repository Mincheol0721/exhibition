package VO.noticeVO;

import java.sql.Date;

public class NoticeVO {
	int no;
	String articleType;
	String title;
	String content;
	String fileName;
	String fileRealName;
	Date writeDate;
	String readCount;
	
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}

	public NoticeVO(int no, String articleType, String title, String content, String fileName, String fileRealName,
			Date writeDate, String readCount) {
		super();
		this.no = no;
		this.articleType = articleType;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	
	
	
}
