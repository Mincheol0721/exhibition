package VO.JobExpVO;

public class cJobExpVO {

	String cname;
	String title;
	String content;
	String iPart;
	String teacher;
	String startTime;
	String endTime;
	String locate;
	String fileName;
	String fileRealName;
	
	
	public cJobExpVO(String cname, String title, String content, String iPart, String teacher, String startTime,
			String endTime, String locate, String fileName, String fileRealName) {
		super();
		this.cname = cname;
		this.title = title;
		this.content = content;
		this.iPart = iPart;
		this.teacher = teacher;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
	}
	public cJobExpVO() {
		// TODO Auto-generated constructor stub
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	public String getiPart() {
		return iPart;
	}
	public void setiPart(String iPart) {
		this.iPart = iPart;
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
	
	
}
