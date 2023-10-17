package VO.IMemberVO;

import java.sql.Date;
import java.sql.Timestamp;

public class IMemberVO {
	private String id; //사용자 아이디
	private String password; // 사용자 비밀번호
	private String ssn; // 사용자 주민등록번호
	private String name; // 사용자 이름
	private String addr; // 주소
	private String itel; // 사용자 연락처
	private String email; //사용자 이메일
	private Date regDate; // 가입일
	private int isAdmin; // 관리자 여부(0: 일반사용자, 1: 관리자)
	
	
	

	//생성자
	public IMemberVO(String id, String password, String ssn, String name, String addr, String itel, String email) {
		super();
		this.id = id;
		this.password = password;
		this.ssn = ssn;
		this.name = name;
		this.addr = addr;
		this.itel = itel;
		this.email = email;
	}

	//getter & setter
	
	
	public String getId() {
		return id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
