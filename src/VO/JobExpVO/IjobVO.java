package VO.JobExpVO;

public class IjobVO {
	
	private int no;
	private String name;
	private String tel;
	private String jobexpname;
	private String regDate;
	
	public IjobVO() {}
	
	public IjobVO(int no, String name, String tel, String jobexpname) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.jobexpname = jobexpname;
	}
	
	public IjobVO(int no, String name, String tel, String jobexpname, String regDate) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.jobexpname = jobexpname;
		this.regDate = regDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getJobexpname() {
		return jobexpname;
	}

	public void setJobexpname(String jobexpname) {
		this.jobexpname = jobexpname;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
}
