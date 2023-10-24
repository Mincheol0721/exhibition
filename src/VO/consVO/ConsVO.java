package VO.consVO;

import java.sql.Date;

public class ConsVO {

	int no;
	String name;
	String title;
	String content;
	String iPart;
	String sitel;
	String ampm;
	String startTime;
	String endTime;
	String locate;
	String homepage;
	String fileName;
	String fileRealName;
	int usePeople;
	Date regDate;
	int reservation;
	String consType;
	
	
	public ConsVO() {
		// TODO Auto-generated constructor stub
	}


	public ConsVO(int no, String name, String title, String content, String iPart, String sitel, String ampm,
			String startTime, String endTime, String locate, String homepage, String fileName, String fileRealName,
			int usePeople, Date regDate, int reservation, String consType) {
		super();
		this.no = no;
		this.name = name;
		this.title = title;
		this.content = content;
		this.iPart = iPart;
		this.sitel = sitel;
		this.ampm = ampm;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
		this.homepage = homepage;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.usePeople = usePeople;
		this.regDate = regDate;
		this.reservation = reservation;
		this.consType = consType;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getSitel() {
		return sitel;
	}


	public void setSitel(String sitel) {
		this.sitel = sitel;
	}


	public String getAmpm() {
		return ampm;
	}


	public void setAmpm(String ampm) {
		this.ampm = ampm;
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


	public int getUsePeople() {
		return usePeople;
	}


	public void setUsePeople(int usePeople) {
		this.usePeople = usePeople;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getReservation() {
		return reservation;
	}


	public void setReservation(int reservation) {
		this.reservation = reservation;
	}


	public String getConsType() {
		return consType;
	}


	public void setConsType(String consType) {
		this.consType = consType;
	}


	
	
	
}
