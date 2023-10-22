package VO.iapplicationVO;

import java.sql.Date;
import java.sql.Timestamp;

public class AllAppFormVO {
	private String name; //사용자 이름
    private String ssn; // 주민등록번호
    private String cname; // 지원한 기업명
    private String addr; // 주소
    private String tel; // 연락처
    private String milServ; // 병역사항
    private String edu; // 최종학력
    private String eduStat; //현재 재학상태(무학, 재학, 졸업, 휴학, 중퇴)
    
    private String id; //사용자 아이디
	private String password; // 사용자 비밀번호
	private String addr1; // 주소
	private String addr2; // 주소
	private String addr3; // 주소
	private String addr4; // 주소
	private String itel; // 사용자 연락처
	private String email; //사용자 이메일
	private Date regDate; // 가입일
	private int isAdmin; // 관리자 여부(0: 일반사용자, 1: 관리자)
    private int memType;  // 회원 타입(개인: 0, 기업: 1)
    private String fileName; //첨부이미지파일(포스터)이름
    private String fileRealName; //첨부파일 실제 이름
    
    //경력사항
    private int no; // 경력사항 번호
    private String carName; // 지원자명
    private String carcName; // 사업체명
    private Timestamp startDate; // 근무 시작 일시
    private Timestamp endDate; // 근무 종료 일시
    private String damdang; // 담당업무
    
    //자격 면허
    private String liname; // 지원자명
    private String lname; // 종목
    private String lnum; // 등록 번호
    private Timestamp getDate; // 발급일자
    private String pub; // 발행처
    
    //교육 및 훈련사항
    private int tno; // 교육(훈련)사항 번호  
    private String trname; // 지원자명
    private String eduName; // 교육 훈련 기관
    private Timestamp trstartDate; // 교육(훈련) 시작 일시
    private Timestamp trendDate; // 교육(훈련) 종료 일시
    private String content; // 교육(훈련) 내용
	
    public AllAppFormVO() {
		
	}
    
    
    public AllAppFormVO(String name, String ssn, String cname, String addr, String tel, String milServ, String edu,
			String eduStat, String id, String password, String addr1, String addr2, String addr3, String addr4,
			String itel, String email, Date regDate, int isAdmin, int memType, String fileName, String fileRealName,
			int no, String carName, String carcName, Timestamp startDate, Timestamp endDate, String damdang,
			String liname, String lname, String lnum, Timestamp getDate, String pub, int tno, String trname,
			String eduName, Timestamp trstartDate, Timestamp trendDate, String content) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.cname = cname;
		this.addr = addr;
		this.tel = tel;
		this.milServ = milServ;
		this.edu = edu;
		this.eduStat = eduStat;
		this.id = id;
		this.password = password;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
		this.itel = itel;
		this.email = email;
		this.regDate = regDate;
		this.isAdmin = isAdmin;
		this.memType = memType;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.no = no;
		this.carName = carName;
		this.carcName = carcName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.damdang = damdang;
		this.liname = liname;
		this.lname = lname;
		this.lnum = lnum;
		this.getDate = getDate;
		this.pub = pub;
		this.tno = tno;
		this.trname = trname;
		this.eduName = eduName;
		this.trstartDate = trstartDate;
		this.trendDate = trendDate;
		this.content = content;
	}
    
    public AllAppFormVO(String id, String password, String ssn, String name, String addr1, String addr2, String addr3,
			String addr4, String itel, String email,String fileRealName) {
		super();
		this.id = id;
		this.password = password;
		this.ssn = ssn;
		this.name = name;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
		this.itel = itel;
		this.email = email;
		this.fileRealName = fileRealName;
	}
    
    
    
    
	public AllAppFormVO(String name, String ssn, String cname, String addr, String tel, String milServ, String edu,
			String eduStat) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.cname = cname;
		this.addr = addr;
		this.tel = tel;
		this.milServ = milServ;
		this.edu = edu;
		this.eduStat = eduStat;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddr1() {
		return addr1;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public String getAddr2() {
		return addr2;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getAddr3() {
		return addr3;
	}


	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}


	public String getAddr4() {
		return addr4;
	}


	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}


	public String getItel() {
		return itel;
	}


	public void setItel(String itel) {
		this.itel = itel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}


	public int getMemType() {
		return memType;
	}


	public void setMemType(int memType) {
		this.memType = memType;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileRealName() {
		return fileRealName;
	}


	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarcName() {
		return carcName;
	}
	public void setCarcName(String carcName) {
		this.carcName = carcName;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getDamdang() {
		return damdang;
	}
	public void setDamdang(String damdang) {
		this.damdang = damdang;
	}
	public String getLiname() {
		return liname;
	}
	public void setLiname(String liname) {
		this.liname = liname;
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
	public Timestamp getGetDate() {
		return getDate;
	}
	public void setGetDate(Timestamp getDate) {
		this.getDate = getDate;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTrname() {
		return trname;
	}
	public void setTrname(String trname) {
		this.trname = trname;
	}
	public String getEduName() {
		return eduName;
	}
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}
	public Timestamp getTrstartDate() {
		return trstartDate;
	}
	public void setTrstartDate(Timestamp trstartDate) {
		this.trstartDate = trstartDate;
	}
	public Timestamp getTrendDate() {
		return trendDate;
	}
	public void setTrendDate(Timestamp trendDate) {
		this.trendDate = trendDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
    
    
    
}
