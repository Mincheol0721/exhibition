package VO.JobExpVO;

public class IJobExpVO {
	
	String name;
	String tel;
	
	public IJobExpVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public IJobExpVO(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
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
	
	
}
