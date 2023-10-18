package VO.appFormVO;

public class CareerExpVO {
	String cname; //사업체명
	String name; //지원자명
	String startDate; //근무시작일
	String endDate; //근무종료일
	String damdang; //담당업무
	
	public CareerExpVO() {}

	public CareerExpVO(String cname, String startDate, String endDate, String damdang) {
		super();
		this.cname = cname;
		this.startDate = startDate;
		this.endDate = endDate;
		this.damdang = damdang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	public String getDamdang() {
		return damdang;
	}

	public void setDamdang(String damdang) {
		this.damdang = damdang;
	}
	
}
