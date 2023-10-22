package service.memberInfoService;



import java.util.List;

import DAO.memberInfoDAO.MemberInfoDAO;
import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;
import VO.appFormVO.AppFormVO;
import VO.iapplicationVO.AllAppFormVO;
import VO.iapplicationVO.CareerExpVO;
import VO.iapplicationVO.LicenseVO;
import VO.iapplicationVO.TrainingVO;



public class MemberInfoService {
	
	private MemberInfoDAO dao;
	
	public MemberInfoService() {
		dao = new MemberInfoDAO();
	}
	//단위기능1. 개인회원 개인정보 조회
	public IMemberVO serviceSearchMyInfo(String id) {
		
		return dao.searchMyInfo(id);
		
	}
	//단위기능2. 개인회원 수정 기능
	public int serviceModifyMyInfo(IMemberVO vo,String id) {
		
		return dao.modifyMyInfo(vo,id);
	}
	//단위기능3. 기업회원 개인정보 조회
	public CMemberVO serviceSearchCInfo(String cno) {
		
		return dao.searchCInfo(cno);
	}
	//단위기능4. 기업회원 수정기능
	public int serviceModifyCInfo(CMemberVO vo, String cno) {
		
		return dao.modifyCInfo(vo,cno);
	}
	
	
	//단위기능6. 입사지원서 등록 기능
	public void serviceAddRegister(IMemberVO iMemVO,AppFormVO appVO,CareerExpVO carVO,LicenseVO licenseVO,TrainingVO trainingVO,String id) {
		
		dao.updateImember(iMemVO,id); //ok
		
		dao.addAppForm(appVO);
		
		dao.addcareerExp(carVO);  //ok
		
		dao.addLicense(licenseVO); //ok
		
		dao.addTraining(trainingVO); //ok
		
	}
	
	//단위기능7. 입사지원서 조회 기능
	public AllAppFormVO serviceSearchMyinfo2(String id) {
		
		return dao.searchMyInfo2(id);
	}
	
	public List<AllAppFormVO> serviceSearchCareerInfo(AllAppFormVO vo) {
		return dao.searchCareerInfo(vo);
		
	}
	public List<AllAppFormVO> serviceSearchTrainingInfo(AllAppFormVO vo) {
		return dao.searchTrainingInfo(vo);
	}
	
	public List<AllAppFormVO> serviceSearchLicenseInfo(AllAppFormVO vo) {
		return dao.searchLicenseInfo(vo);
	}
	public List<AllAppFormVO> serviceSearchAppFormInfo(AllAppFormVO vo) {
		return dao.searchAppFormInfo(vo);
	}
	
	
}
