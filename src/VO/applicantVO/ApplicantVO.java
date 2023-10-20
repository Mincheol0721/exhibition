package VO.applicantVO;

import java.sql.Date;

public class ApplicantVO {
	
	private String cname,			//주최기업명
				   title,			//글제목
				   content,			//글내용
				   ipart,			//참여대상
				   teacher,			//강사
				   startTime,		//이용시간(시작)
				   endTime,			//이용시간(종료)
				   locate,			//행사 장소
				   fileName,		//첨부파일 이름
				   fileRealName,	//첨부파일 실제이름
				   startDate,		//프로그램 시작일자
				   endDate; 		//프로그램 종료일자
	private int isrecog;			//승인여부
	
	public ApplicantVO() {}

	public ApplicantVO(String cname, String title, String content, String ipart, String teacher, String startTime,
			String endTime, String locate, String startDate, String endDate) {
		super();
		this.cname = cname;
		this.title = title;
		this.content = content;
		this.ipart = ipart;
		this.teacher = teacher;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ApplicantVO(String cname, String title, String content, String ipart, String teacher, String startTime,
			String endTime, String locate, String fileName, String fileRealName, String startDate, String endDate) {
		super();
		this.cname = cname;
		this.title = title;
		this.content = content;
		this.ipart = ipart;
		this.teacher = teacher;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIpart() {
		return ipart;
	}

	public void setIpart(String ipart) {
		this.ipart = ipart;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getIsrecog() {
		return isrecog;
	}

	public void setIsrecog(int isrecog) {
		this.isrecog = isrecog;
	}
	
	
	/* 개인 회원 직업체험신청 */
	private int no;				//행사정보번호
	private String tel,			//연락처
				   name,		//참가자명
				   jobexpname,	//직업체험명
				   regDate;		//신청날짜

	public ApplicantVO(String tel, String name, String jobexpname) {
		super();
		this.tel = tel;
		this.name = name;
		this.jobexpname = jobexpname;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJobexpname() {
		return jobexpname;
	}

	public void setJobexpname(String jobexpname) {
		this.jobexpname = jobexpname;
	}

	/* 컨설팅 VO */
	private int usePeople,
				reservation;
	private String ampm,
				   homepage,
				   constype,
				   sitel;

	public ApplicantVO(String title, String content, String ipart, String startTime, String endTime, String locate,
			String fileName, String fileRealName, String startDate, String endDate, int usePeople,
			int reservation, String ampm, String homepage, String constype, String sitel) {
		
		super();
		this.title = title;
		this.content = content;
		this.ipart = ipart;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locate = locate;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.usePeople = usePeople;
		this.reservation = reservation;
		this.ampm = ampm;
		this.homepage = homepage;
		this.constype = constype;
		this.sitel = sitel; 
	}

	public int getUsePeople() {
		return usePeople;
	}

	public void setUsePeople(int usePeople) {
		this.usePeople = usePeople;
	}

	public int getReservation() {
		return reservation;
	}

	public void setReservation(int reservation) {
		this.reservation = reservation;
	}

	public String getAmpm() {
		return ampm;
	}

	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getConstype() {
		return constype;
	}

	public void setConstype(String constype) {
		this.constype = constype;
	}

	public String getSitel() {
		return sitel;
	}

	public void setSitel(String sitel) {
		this.sitel = sitel;
	}
	
}
