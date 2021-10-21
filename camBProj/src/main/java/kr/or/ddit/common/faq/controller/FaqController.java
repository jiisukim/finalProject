package kr.or.ddit.common.faq.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.common.faq.service.FaqService;
import kr.or.ddit.common.faq.vo.FaqVO;
import kr.or.ddit.util.code.service.CodeService;
import kr.or.ddit.util.code.vo.CodeVO;
import kr.or.ddit.util.file.controller.FileController;
import kr.or.ddit.util.file.vo.AttachFileVO;


@Controller
@RequestMapping("/common/faq/")
public class FaqController {
   
   @Autowired
   private FaqService faqService;   
   @Autowired
   FileController fileController;   
   @Autowired
   private CodeService codeService;
   
   Logger logger = LoggerFactory.getLogger(FaqController.class);
   //리스트
   @RequestMapping(value="/faqList", method=RequestMethod.GET)
   public String faqList(Model model, @RequestParam(defaultValue ="1") String pageNo
   , @RequestParam Map<String, Object>map) {
      
      if(map.get("pageNo")==null) {
         logger.info("pageNo null");
         map.put("pageNo", 1);
      }
      if(map.get("search")==null) {
         logger.info("search null");
         map.put("search", "");
      }
      //추가한 거-----------------------------
      if(map.get("faqKwdCode")==null) {
    	  logger.info("faqKwdCode null");
    	  map.put("faqKwdCode", "");
      }
      //-----------------------------------
      if(map.get("keyword")==null) {
         logger.info("keyword null");
         map.put("keyword", "");
      }
      logger.info("map : "+ map);
      List<FaqVO> list = this.faqService.faqList(map);   
      model.addAttribute("list", list);
      
      PaginationInfo paginationInfo = new PaginationInfo();
      int totalCount = this.faqService.selectCount(map);
      model.addAttribute("totalCount", totalCount);
      paginationInfo.setTotalRecordCount(totalCount);
      paginationInfo.setCurrentPageNo(Integer.parseInt(pageNo));
      paginationInfo.setRecordCountPerPage(5); 
      paginationInfo.setPageSize(5);   
      
      model.addAttribute("paginationInfo", paginationInfo );
      return "common/faq/faqList";
   }
   
   //등록창
   @RequestMapping(value="/faqInsert",method=RequestMethod.GET)
   public String faqInsert(Model model) {
      
      List<CodeVO> codeList = this.codeService.codeList("FAQ_KWD");
      model.addAttribute("codeList", codeList);
      
      return "common/faq/faqInsert";
   }
   
   //등록
   @RequestMapping(value="/faqInsert",method=RequestMethod.POST)
   public String faqInsertPost(@ModelAttribute FaqVO faqVo, Model model
		   					  ,@RequestParam(value="fileCheck", required=false) String fileCheck ) {
      
	   logger.info("FAQ>>>>>>>>>" + faqVo);
	// --file 시작--
			String fileGrNum = "";
			if(fileCheck!=null) {
				fileGrNum = fileController.fileUpload(faqVo.getFileList());
				faqVo.setFileGrNum(fileGrNum);
			}
	// --file 끝--
	   
      int result = this.faqService.faqInsert(faqVo);
 
      return "redirect:/common/faq/faqList";
   }
      
   //상세내역
   @RequestMapping(value="/faqDetail",method=RequestMethod.GET)
   public String faqDetail(@RequestParam String artcNum,
         Model model) {
         
      FaqVO fv = this.faqService.faqDetail(artcNum);
      
      
      List<CodeVO> codeList = this.codeService.codeList("FAQ_KWD");
      model.addAttribute("codeList", codeList);
      model.addAttribute("fv", fv);
      
		if(fv.getFileGrNum() != null) { // 파일이 들어 있을 경우
			List<AttachFileVO> fileList = fileController.fileList(fv.getFileGrNum());
			model.addAttribute("fileList", fileList);
		}
      
      return "common/faq/faqDetail";
   }

   //삭제
   @RequestMapping(value="/faqDelete",method = RequestMethod.POST)
   public String faqDelete(@RequestParam String artcNum) {
      
      int del = this.faqService.faqDelete(artcNum);
      
   return "redirect:/common/faq/faqList";
   }
   
   //수정
   @RequestMapping(value="/faqUpdate", method = RequestMethod.GET)
   public String faqUpdate(FaqVO faqVO, Model model) {
	   
	   List<CodeVO> codeList = this.codeService.codeList("FAQ_KWD");
	   model.addAttribute("codeList", codeList);
	   FaqVO fv = this.faqService.faqDetail(faqVO.getArtcNum());
	   BeanUtils.copyProperties(fv, faqVO);
	   
		if(fv.getFileGrNum() != null) { // 파일이 들어 있을 경우
			List<AttachFileVO> fileList = fileController.fileList(fv.getFileGrNum());
			model.addAttribute("fileList", fileList);
		}
	   
	   return "common/faq/faqUpdate";
   }
   //수정
   @RequestMapping(value="/faqUpdate", method = RequestMethod.POST)
   public String faqUpdatePost(@ModelAttribute FaqVO faqVo, 
		   					   @RequestParam(value="fileCheck",required = false) String fileCheck) {
      
		
		if(fileCheck!=null) {
			String fileGrNum = fileController.fileUpload(faqVo.getFileList());
			faqVo.setFileGrNum(fileGrNum);
		}
      
		int result = this.faqService.faqUpdate(faqVo);
		
      return "redirect:/common/faq/faqDetail?artcNum="+ faqVo.getArtcNum();
   }
   
}