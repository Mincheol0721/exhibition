package VO.consVO;


public class ConsVO {
	private int no; // 글번호
    private String name; // 신청자명
    private String title; // 글 제목
    private String ampm; // 오전, 오후
    private String startTime; // 이용 시간(시작)
    private String endTime; // 이용 시간(종료)
    private String locate; // 행사 장소
	private String ConsType;// 컨설팅 종류
	
	//생성자
	public ConsVO(int no, String name, String title, String ampm, String startTime, String endTime, String locate,
			String consType) {
		super();
		this.no = no;
		this.name = name;
		this.title = title;
		this.ampm = ampm;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
		ConsType = consType;
	}
	
	//getter & setter
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
	public String getConsType() {
		return ConsType;
	}
	public void setConsType(String consType) {
		ConsType = consType;
	}
	
		
    	
    
    
}