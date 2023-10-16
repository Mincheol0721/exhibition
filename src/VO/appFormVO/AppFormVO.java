package VO.appFormVO;

public class AppFormVO {
	String name; //지원자명
	String ssn; //지원자 주민등록번호
	String addr; //지원자 집주소
	String tel; //지원자 전화번호
	String milServ; //지원자 병역이행여부
	String edu; //지원자 최종학력
	String eduStat; //학력상태
	CareerExpVO carExp; //경력사항
	LicenseVO license; //자격면허
	TrainingVO training; //교육 및 훈련사항
	
	public AppFormVO() {}
	
	public AppFormVO(String name, String ssn, String addr, String tel, String milServ, String edu, String eduStat) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.addr = addr;
		this.tel = tel;
		this.milServ = milServ;
		this.edu = edu;
		this.eduStat = eduStat;
	}

	public AppFormVO(String name, String ssn, String addr, String tel, String milServ, String edu, String eduStat,
			CareerExpVO carExp, LicenseVO license, TrainingVO training) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.addr = addr;
		this.tel = tel;
		this.milServ = milServ;
		this.edu = edu;
		this.eduStat = eduStat;
		this.carExp = carExp;
		this.license = license;
		this.training = training;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMilServ() {
		return milServ;
	}

	public void setMilServ(String milServ) {
		this.milServ = milServ;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getEduStat() {
		return eduStat;
	}

	public void setEduStat(String eduStat) {
		this.eduStat = eduStat;
	}

	public CareerExpVO getCarExp() {
		return carExp;
	}

	public void setCarExp(CareerExpVO carExp) {
		this.carExp = carExp;
	}

	public LicenseVO getLicense() {
		return license;
	}

	public void setLicense(LicenseVO license) {
		this.license = license;
	}

	public TrainingVO getTraining() {
		return training;
	}

	public void setTraining(TrainingVO training) {
		this.training = training;
	}
	
}
