package VO.IMemberVO;

import java.sql.Date;
import java.sql.Timestamp;

public class IMemberVO {
	private String id; //사용자 아이디
	private String password; // 사용자 비밀번호
	private String ssn; // 사용자 주민등록번호
	private String name; // 사용자 이름
	private String addr1; // 주소
	private String addr2; // 주소
	private String addr3; // 주소
	private String addr4; // 주소
	private String itel; // 사용자 연락처
	private String email; //사용자 이메일
	private String regDate; // 가입일
	private int isAdmin; // 관리자 여부(0: 일반사용자, 1: 관리자)
    private int isSeek;  // 구직상태 (0: 구직(실직), 1: 재직, 2: 휴직 / -1: 관리자)
    private String fileName; //첨부이미지파일(포스터)이름
    private String fileRealName; //첨부파일 실제 이름
	
    public IMemberVO() {}
    
	public IMemberVO(String id, String password, String ssn, String name, String addr1, String addr2, String addr3,
			String addr4, String itel, String email, String fileName, String fileRealName) {
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
		this.fileName = fileName;
		this.fileRealName = fileRealName;
	}
	
	public IMemberVO(String password, String name, String addr1, String addr2, String addr3, String addr4, String itel,
			String email) {
		super();
		this.password = password;
		this.name = name;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
		this.itel = itel;
		this.email = email;
	}

	//getter & setter
	public String getId() {
		return id;
	}
	public int getIsSeek() {
		return isSeek;
	}



	public void setIsSeek(int isSeek) {
		this.isSeek = isSeek;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	


	
	
	
	
}
