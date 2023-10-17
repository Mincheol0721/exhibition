package VO.eventInfoVO;

//eventInfo테이블 
public class EventInfoVO {
    int no;					// 글번호
    String name;			// 행사명
    String startDate;		// 시작일시
    String endDate;  		// 종료일시
    String locate;    		// 장소
    String iPart;  			// 참여대상(개인)
    String cPart;  			// 참여기업
    String fileName; 		// 첨부이미지파일(포스터)이름
    String fileRealName; 	// 첨부이미지파일(포스터)실제이름
    
    //기본 생성자
    public EventInfoVO() {
		
	}    

	public EventInfoVO(int no, String name, String startDate, String endDate, String locate, String iPart, String cPart,
			String fileName, String fileRealName) {
		this.no = no;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.locate = locate;
		this.iPart = iPart;
		this.cPart = cPart;
		this.fileName = fileName;
		this.fileRealName = fileRealName;
	}

	//getter, setter메소드들
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

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	public String getiPart() {
		return iPart;
	}

	public void setiPart(String iPart) {
		this.iPart = iPart;
	}

	public String getcPart() {
		return cPart;
	}

	public void setcPart(String cPart) {
		this.cPart = cPart;
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
    
    
}
