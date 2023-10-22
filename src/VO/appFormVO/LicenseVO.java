package VO.appFormVO;

public class LicenseVO {
	String lname; //자격면허 종목
	String name; //지원자명
	String lnum; //등록번호
	String getDate; //발급일자
	String pub; //발행처
	
	public LicenseVO() {}

	public LicenseVO(String lname, String getDate, String pub) {
		super();
		this.lname = lname;
		this.getDate = getDate;
		this.pub = pub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLnum() {
		return lnum;
	}

	public void setLnum(String lnum) {
		this.lnum = lnum;
	}

	public String getGetDate() {
		return getDate;
	}

	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}
	
}
