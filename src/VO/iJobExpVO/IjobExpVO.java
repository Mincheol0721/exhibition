package VO.iJobExpVO;

import java.sql.Timestamp;

public class IjobExpVO {
	// 직업체험 신청(개인)
	
	    private int no; // 행사 정보 번호
	    private String tel; // 개인연락처
	    private String name; // 참가자명
	    private String jobexpname; // 직업체험명(글제목)
	    private Timestamp regDate; // 체험 신청 날짜
		
	    //생성자
	    public IjobExpVO(int no, String tel, String name, String jobexpname, Timestamp regDate) {
			super();
			this.no = no;
			this.tel = tel;
			this.name = name;
			this.jobexpname = jobexpname;
			this.regDate = regDate;
		}
	    
	    public IjobExpVO() {
			
		}
	    
	    //getter & setter
		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getJobexpname() {
			return jobexpname;
		}

		public void setJobexpname(String jobexpname) {
			this.jobexpname = jobexpname;
		}

		public Timestamp getRegDate() {
			return regDate;
		}

		public void setRegDate(Timestamp regDate) {
			this.regDate = regDate;
		}
	    
	    
	    
}
