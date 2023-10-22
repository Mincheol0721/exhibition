package VO.iapplicationVO;

public class LicenseVO {
	private String licenseName1; 
	private String licenseName2; 
	private String licenseName3; 
	private String lname1; 
	private String lname2; 
	private String lname3;
	private String lnum1;
	private String lnum2;
	private String lnum3;
	private String getDate1;
	private String getDate2;
	private String getDate3;
	private String pub1;
	private String pub2;
	private String pub3;
	
	//생성자
	public LicenseVO(String licenseName1, String licenseName2, String licenseName3, String lname1, String lname2,
			String lname3, String lnum1, String lnum2, String lnum3, String getDate1, String getDate2, String getDate3,
			String pub1, String pub2, String pub3) {
		super();
		this.licenseName1 = licenseName1;
		this.licenseName2 = licenseName2;
		this.licenseName3 = licenseName3;
		this.lname1 = lname1;
		this.lname2 = lname2;
		this.lname3 = lname3;
		this.lnum1 = lnum1;
		this.lnum2 = lnum2;
		this.lnum3 = lnum3;
		this.getDate1 = getDate1;
		this.getDate2 = getDate2;
		this.getDate3 = getDate3;
		this.pub1 = pub1;
		this.pub2 = pub2;
		this.pub3 = pub3;
	}
	
	//getter & setter
	public String getLicenseName1() {
		return licenseName1;
	}

	public void setLicenseName1(String licenseName1) {
		this.licenseName1 = licenseName1;
	}

	public String getLicenseName2() {
		return licenseName2;
	}

	public void setLicenseName2(String licenseName2) {
		this.licenseName2 = licenseName2;
	}

	public String getLicenseName3() {
		return licenseName3;
	}

	public void setLicenseName3(String licenseName3) {
		this.licenseName3 = licenseName3;
	}

	public String getLname1() {
		return lname1;
	}

	public void setLname1(String lname1) {
		this.lname1 = lname1;
	}

	public String getLname2() {
		return lname2;
	}

	public void setLname2(String lname2) {
		this.lname2 = lname2;
	}

	public String getLname3() {
		return lname3;
	}

	public void setLname3(String lname3) {
		this.lname3 = lname3;
	}

	public String getLnum1() {
		return lnum1;
	}

	public void setLnum1(String lnum1) {
		this.lnum1 = lnum1;
	}

	public String getLnum2() {
		return lnum2;
	}

	public void setLnum2(String lnum2) {
		this.lnum2 = lnum2;
	}

	public String getLnum3() {
		return lnum3;
	}

	public void setLnum3(String lnum3) {
		this.lnum3 = lnum3;
	}

	public String getGetDate1() {
		return getDate1;
	}

	public void setGetDate1(String getDate1) {
		this.getDate1 = getDate1;
	}

	public String getGetDate2() {
		return getDate2;
	}

	public void setGetDate2(String getDate2) {
		this.getDate2 = getDate2;
	}

	public String getGetDate3() {
		return getDate3;
	}

	public void setGetDate3(String getDate3) {
		this.getDate3 = getDate3;
	}

	public String getPub1() {
		return pub1;
	}

	public void setPub1(String pub1) {
		this.pub1 = pub1;
	}

	public String getPub2() {
		return pub2;
	}

	public void setPub2(String pub2) {
		this.pub2 = pub2;
	}

	public String getPub3() {
		return pub3;
	}

	public void setPub3(String pub3) {
		this.pub3 = pub3;
	}
	
	
	
}
