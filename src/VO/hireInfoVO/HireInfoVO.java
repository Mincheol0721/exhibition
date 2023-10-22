package VO.hireInfoVO;

public class HireInfoVO {
	String cname; //기업명
	String htel; //기업 전화번호
	String divComp; //사업체 구분(일반기업, 공공기관 사회적기업 등)
	String homepage; //홈페이지 링크
	String jobtype; //모집직종
	String workTime; //근무시간
	String legal; //근무지역
	String appType; //접수종류(서류, 면접)
	String appstart; //접수시작일
	String appexpire; //접수마감일
	int expireDate; //d-day를 출력하기 위해 저장할 변수
	
	public HireInfoVO() {}

	public HireInfoVO(String cname, String htel, String divComp, String homepage, String jobtype, String workTime, String legal) {
		this.cname = cname;
		this.htel = htel;
		this.divComp = divComp;
		this.homepage = homepage;
		this.jobtype = jobtype;
		this.workTime = workTime;
		this.legal = legal;
	}
	
	public HireInfoVO(String cname, String htel, String divComp, String homepage, String jobtype, String workTime,
			String legal, String appType, String appstart, String appexpire) {
		super();
		this.cname = cname;
		this.htel = htel;
		this.divComp = divComp;
		this.homepage = homepage;
		this.jobtype = jobtype;
		this.workTime = workTime;
		this.legal = legal;
		this.appType = appType;
		this.appstart = appstart;
		this.appexpire = appexpire;
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

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
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

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getAppstart() {
		return appstart;
	}

	public void setAppstart(String appstart) {
		this.appstart = appstart;
	}

	public String getAppexpire() { 
		return appexpire;
	}

	public void setAppexpire(String appexpire) {
		this.appexpire = appexpire;
	}

	public int getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(int expireDate) {
		this.expireDate = expireDate;
	}
	
}
