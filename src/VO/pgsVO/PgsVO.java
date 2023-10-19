package VO.pgsVO;

import java.sql.Date;

public class PgsVO {
	
	private int pno; 				//프로그램번호
	private String pgname,			//프로그램명
				   pgtype,			//프로그램타입(상담, 컨설팅, 특강)
				   title,			//글제목
				   content,			//글내용
				   ipart,			//참여대상
				   teacher,			//강사
				   startTime,		//이용시간(시작)
				   endTime,			//이용시간(종료)
				   locate,			//행사 장소
				   fileName,		//첨부파일 이름
				   fileRealName;	//첨부파일 실제이름
	private Date startDate,			//프로그램 시작일자
				 endDate; 			//프로그램 종료일자
	
	public PgsVO() {}

	public PgsVO(int pno, String pgname, String pgtype, String title, String content, String ipart, String teacher,
			String startTime, String endTime, String locate) {
		super();
		this.pno = pno;
		this.pgname = pgname;
		this.pgtype = pgtype;
		this.title = title;
		this.content = content;
		this.ipart = ipart;
		this.teacher = teacher;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
	}
	
	public PgsVO(int pno, String pgname, String pgtype, String title, String content, String ipart, String teacher,
			String startTime, String endTime, String locate, String fileName, String fileRealName, Date startDate,
			Date endDate) {
		super();
		this.pno = pno;
		this.pgname = pgname;
		this.pgtype = pgtype;
		this.title = title;
		this.content = content;
		this.ipart = ipart;
		this.teacher = teacher;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPgname() {
		return pgname;
	}

	public void setPgname(String pgname) {
		this.pgname = pgname;
	}

	public String getPgtype() {
		return pgtype;
	}

	public void setPgtype(String pgtype) {
		this.pgtype = pgtype;
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

	public String getIpart() {
		return ipart;
	}

	public void setIpart(String ipart) {
		this.ipart = ipart;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
