package VO.CMemberVO;

public class CMemberVO {
	private String cno; // 기업회원 사업자등록번호
    private String ctel; // 기업회원 회사전화번호
    private String name; // 기업회원 대표자명
    private String cname; // 기업명
    private String divcomp; //기업 사업체 구분(일반기업, 공공기관, 사회적기업)
    private String jobtype; //모집 직종
    private String password; //비밀번호
	
    //모든 변수를 매개변수로 받는 생성자
    public CMemberVO(String cno, String ctel, String name, String cname, String divcomp, String jobtype,String password) {
		super();
		this.cno = cno;
		this.ctel = ctel;
		this.name = name;
		this.cname = cname;
		this.divcomp = divcomp;
		this.jobtype = jobtype;
		this.password = password;
	}
    
    //getter & setter
    
    
	public CMemberVO() {
		
	}

	public String getCno() {
		return cno;
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
