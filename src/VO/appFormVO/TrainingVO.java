package VO.appFormVO;

public class TrainingVO {
	int tno; //교육사항번호
	String name; //지원자명
	String eduName; //교육 훈련 종목명
	String startDate; //교육훈련 시작일시
	String endDate; //교육훈련 종료일시
	String content; //교육훈련 내용
	
	public TrainingVO() {}

	public TrainingVO(int tno, String eduName, String startDate, String endDate, String content) {
		super();
		this.tno = tno;
		this.eduName = eduName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getEduName() {
		return eduName;
	}

	public void setEduName(String eduName) {
		this.eduName = eduName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
