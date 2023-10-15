package VO.hireInfoVO;

public class HireInfoVO {
	String cname; //기업명
	String htel; //기업 전화번호
	String divComp; //사업체 구분(일반기업, 공공기관 사회적기업 등)
	String homepage; //홈페이지 링크
	String jobType; //모집직종
	String workTime; //근무시간
	String legal; //근무지역
	
	public HireInfoVO() {}

	public HireInfoVO(String cname, String htel, String divComp, String homepage, String jobType, String workTime, String legal) {
		this.cname = cname;
		this.htel = htel;
		this.divComp = divComp;
		this.homepage = homepage;
		this.jobType = jobType;
		this.workTime = workTime;
		this.legal = legal;
	}



	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getHtel() {
		return htel;
	}

	public void setHtel(String htel) {
		this.htel = htel;
	}

	public String getDivComp() {
		return divComp;
	}

	public void setDivComp(String divComp) {
		this.divComp = divComp;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}
	
}
