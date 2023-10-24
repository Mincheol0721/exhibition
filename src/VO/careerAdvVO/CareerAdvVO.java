package VO.careerAdvVO;

public class CareerAdvVO {

	int no;
	String title;
	String content;
	String iPart;
	String startTime;
	String endTime;
	String locate;
	String homepage;
	String fileName;
	String fileRealName;
	String catel;
	
	
	public CareerAdvVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CareerAdvVO(int no, String title, String content, String iPart, String startTime, String endTime,
			String locate, String homepage, String fileName, String fileRealName, String catel) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.iPart = iPart;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
		this.homepage = homepage;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.catel = catel;
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


	public String getiPart() {
		return iPart;
	}


	public void setiPart(String iPart) {
		this.iPart = iPart;
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


	public String getHomepage() {
		return homepage;
	}


	public void setHomepage(String homepage) {
		this.homepage = homepage;
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


	public String getCatel() {
		return catel;
	}


	public void setCatel(String catel) {
		this.catel = catel;
	}
	
	
	
}
