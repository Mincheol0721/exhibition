package VO.eventVO;

public class EventVO {
	private int no;
	private String title;
	private String content;
	private String ipart;
	private String reqTime;
	private String startTime;
	private String endTime;
	private String service;
	private String locate;
	
	public EventVO() {}

	public EventVO(String title, String content, String ipart, String reqTime, String startTime, String endTime,
			String service, String locate) {
		super();
		this.title = title;
		this.content = content;
		this.ipart = ipart;
		this.reqTime = reqTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.service = service;
		this.locate = locate;
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

	public String getIpart() {
		return ipart;
	}

	public void setIpart(String ipart) {
		this.ipart = ipart;
	}

	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
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

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}
	
}
