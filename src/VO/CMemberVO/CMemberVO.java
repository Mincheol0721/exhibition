package VO.CMemberVO;

public class CMemberVO {
	private String cno; // 기업회원 사업자등록번호
    private String ctel; // 기업회원 회사전화번호
    private String name; // 기업회원 대표자명
    private String cname; // 기업명
    private String divcomp; //기업 사업체 구분(일반기업, 공공기관, 사회적기업)
    private String jobtype; //모집 직종
    private String password; //비밀번호
    private int memType; //회원 타입(개인: 0, 기업: 1)
    private String fileName; // 첨부이미지파일(포스터)이름
    private String fileRealName; // 첨부이미지파일(포스터) 실제이름
    private String addr1;   // 기업 주소
    private String addr2; 
    private String addr3; 
    private String addr4;
	
	public CMemberVO() {}
    
    public CMemberVO(String cno, String ctel, String name, String cname, String divcomp, String jobtype,
			String password, String fileName, String fileRealName, String addr1, String addr2, String addr3,
			String addr4) {
		super();
		this.cno = cno;
		this.ctel = ctel;
		this.name = name;
		this.cname = cname;
		this.divcomp = divcomp;
		this.jobtype = jobtype;
		this.password = password;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
	}
    
    

	public CMemberVO(String ctel, String name, String cname, String divcomp, String jobtype, String password,
			String addr1, String addr2, String addr3, String addr4) {
		super();
		this.ctel = ctel;
		this.name = name;
		this.cname = cname;
		this.divcomp = divcomp;
		this.jobtype = jobtype;
		this.password = password;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
	}

	//getter & setter
	public String getCno() {
		return cno;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
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

	public String getDivcomp() {
		return divcomp;
	}

	public void setDivcomp(String divcomp) {
		this.divcomp = divcomp;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
    
    
}
