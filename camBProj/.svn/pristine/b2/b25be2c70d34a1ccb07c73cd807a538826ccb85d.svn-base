package kr.or.ddit.admin.univDep.web;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.admin.univDep.service.UnivDepService;
import kr.or.ddit.admin.univDep.vo.UnivDepVO;
import kr.or.ddit.admin.univDep.vo.UnivVO;

@Controller
@RequestMapping(value = "/admin/univDep/*")
public class UnivDepController {
	
	private static Logger logger = LoggerFactory.getLogger(UnivDepController.class);
	
	@Autowired
	UnivDepService univDepService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectUnivDepList(@ModelAttribute UnivDepVO univDepVo, Model model) throws Exception {
		
//		학과 목록
		List<UnivDepVO> list = univDepService.selectUnivDepList(univDepVo);
		logger.info("list : "+list);
		model.addAttribute("list", list);
		
//		페이징 처리
		PaginationInfo pagination = new PaginationInfo();
		pagination.setCurrentPageNo(univDepVo.getPageNo());
		pagination.setRecordCountPerPage(univDepVo.getRecordCountPerPage());
		pagination.setPageSize(univDepVo.getPageSize());
		pagination.setTotalRecordCount(univDepService.totalUnivDep(univDepVo));
		
		int lastRecordIndex = pagination.getLastRecordIndex();
		
		if(lastRecordIndex > pagination.getTotalRecordCount()) {
			lastRecordIndex = pagination.getTotalRecordCount();
		}
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("lastRecordIndex", lastRecordIndex);
		
		return "admin/univDep/list";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertUnivDep(Model model) throws Exception {
		
//		대학리스트
		List<UnivVO> univList = univDepService.selectUnivList();
		logger.debug("univList : " + univList);
		model.addAttribute("univList", univList);
		
		return "admin/univDep/insert";
	}
	
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertUnivDepPost (@ModelAttribute UnivDepVO univDepVo) throws Exception {
		
//		입력받은 학과 정보
		logger.info("맨 처음의 univDepVO : " + univDepVo.toString());
		
//		학과 등록 전 학과 번호 생성 및 VO에 세팅
		String univDeptNum = univDepService.makeUnivDepNum(); 
		logger.info("만들어진 학과 번호 univDeptNum : " + univDeptNum);
		univDepVo.setUnivDeptNum(univDeptNum);
		
//		학과 등록
		String univDeptNumResult = univDepService.insertUnivDep(univDepVo);
		logger.info("입력된 학과 번호 univDeptNumResult : " + univDeptNumResult);
		
		return "redirect:/admin/univDep/detail?univDeptNum="+univDeptNumResult;
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailUnivDep(@RequestParam(value = "univDeptNum", required = false) String univDeptNum,
			Model model) throws Exception {
		
		logger.info("디테일 univDeptNum : " + univDeptNum);
		
		UnivDepVO univDepVo = univDepService.selectUnivDepDetail(univDeptNum);
		logger.info("디테일 univDepVo : " + univDepVo.toString());
		
//		대학리스트
		List<UnivVO> univList = univDepService.selectUnivList();
		logger.debug("univList : " + univList);
		model.addAttribute("univList", univList);
		
		model.addAttribute("univDepVo", univDepVo);

		return "admin/univDep/detail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUnivDepPost(@ModelAttribute UnivDepVO univDepVo) throws Exception {
		logger.info("updateUnivDepVO : " + univDepVo.toString());
		
		int result = univDepService.updateUnivDep(univDepVo);
		logger.info("updateResult : " + result);
		
		logger.info("업데이트 시작");
		
		return "redirect:/admin/univDep/detail?univDeptNum="+univDepVo.getUnivDeptNum();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteUnivDep(@ModelAttribute UnivDepVO univDepVo) throws Exception {
		logger.info("deleteUnivDepVO : " + univDepVo.toString());
		
		int result = univDepService.deleteUnivDep(univDepVo);
		logger.info("deleteResult : " + result);
		
		return "redirect:/admin/univDep/list";
	}

}
