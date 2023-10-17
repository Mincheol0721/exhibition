package VO.appFormVO;

public class AppFormVO {
	
	/* 입사지원서 테이블 */
	String name; //지원자명
	String ssn; //지원자 주민등록번호
	String addr; //지원자 집주소
	String tel; //지원자 전화번호
	String milServ; //지원자 병역이행여부
	String edu; //지원자 최종학력
	String eduStat; //학력상태
	
	/* 경력사항 테이블 */
	String cname; //사업체명 
	String cstartDate; //근무시작일
	String cendDate; //근무종료일
	String damdang; //담당업무
	
	/* 자격(면허)증 테이블 */
	String lname; //자격면허 종목
	String lnum; //등록번호
	String getDate; //발급일자
	String pub; //발행처
	
	/* 교육(훈련)사항 테이블 */
	int tno; //교육사항번호
	String eduName; //교육 훈련 종목명
	String tstartDate; //교육훈련 시작일시
	String tendDate; //교육훈련 종료일시
	String content; //교육훈련 내용
	
	/* 입사지원서 생성자 및 getter, setter */ 
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


	/* 경력사항 생성자 및 getter, setter */
	public AppFormVO(String cname, String cename, String cstartDate, String cendDate, String damdang) {
		super();
		this.cname = cname;
		this.cstartDate = cstartDate;
		this.cendDate = cendDate;
		this.damdang = damdang;
	}
	
	public String getCname() {
		return cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public String getCstartDate() {
		return cstartDate;
	}

	public void setCstartDate(String cstartDate) {
		this.cstartDate = cstartDate;
	}

	public String getCendDate() {
		return cendDate;
	}

	public void setCendDate(String cendDate) {
		this.cendDate = cendDate;
	}

	public String getDamdang() {
		return damdang;
	}
	
	public void setDamdang(String damdang) {
		this.damdang = damdang;
	}

	/* 자격(면허)증 생성자 및 getter, setter */
	public AppFormVO(String lname, String lnum, String getDate, String pub) {
		super();
		this.lname = lname;
		this.lnum = lnum;
		this.getDate = getDate;
		this.pub = pub;
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

	/* 교육(훈련)사항 생성자 및 getter, setter */
	public AppFormVO(int tno, String eduName, String tstartDate, String tendDate, String content) {
		super();
		this.tno = tno;
		this.eduName = eduName;
		this.tstartDate = tstartDate;
		this.tendDate = tendDate;
		this.content = content;
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

	public String getTstartDate() {
		return tstartDate;
	}

	public void setTstartDate(String tstartDate) {
		this.tstartDate = tstartDate;
	}

	public String getTendDate() {
		return tendDate;
	}

	public void setTendDate(String tendDate) {
		this.tendDate = tendDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
