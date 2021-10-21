package kr.or.ddit.common.calendar.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.calendar.service.impl.CalendarService;
import kr.or.ddit.common.calendar.vo.CalendarVO;
import kr.or.ddit.util.code.service.CodeService;
import kr.or.ddit.util.code.vo.CodeVO;

@Controller
@RequestMapping(value = "/common/calendar/*")
public class CalendarController {

	private Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	@Autowired(required = false)
	private CalendarService calenderService;
	
	@Autowired
	private CodeService codeService;
	
	@RequestMapping(value = "/calendarList", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		List<CodeVO> autLin = codeService.codeList("ACA_CAL");
		logger.debug(autLin.toString());
		
		model.addAttribute("autLin", autLin);
		
		return "/common/calendar/calendarList";
	}
	
	@RequestMapping("/calendarData")
	@ResponseBody
    public List<CalendarVO> data() throws Exception {
        
      List<CalendarVO> list= calenderService.calenderList();
      System.out.println("list >>> " + list);
      
      return list;
        
    }
	
	@RequestMapping(value = "/insertCalendar", method = RequestMethod.POST) 
	public String insertList(@ModelAttribute CalendarVO calendarVo) throws Exception {
		
		logger.debug("인서트 CalendarVO : " + calendarVo.toString());
		
		int result = calenderService.insertCalendar(calendarVo);
		logger.debug("result : " + result);
		
		return "redirect:/common/calendar/calendarList";
		
	}
	
//	쓰이지 않음.. 필요없는 아이 일까나
	@RequestMapping("/calendarDataDetail")
	@ResponseBody
    public CalendarVO dataDetail(CalendarVO calendarVo) throws Exception {
        
		CalendarVO dataDetail = calenderService.calendarDetail(calendarVo);
		
      return dataDetail;
        
    }
	
	@RequestMapping(value = "/updateCalendar", method = RequestMethod.POST) 
	public String updateCalendar(@ModelAttribute CalendarVO calendarVo) throws Exception {

		logger.debug("업데이트 CalendarVO : " + calendarVo.toString());
		
		int result = calenderService.calendarUpdate(calendarVo);
		logger.debug("result : " + result);
		
		return "redirect:/common/calendar/calendarList";
		
	}
	
	@RequestMapping(value = "/deleteCalendar", method = RequestMethod.POST) 
	public String deleteCalendar(@ModelAttribute CalendarVO calendarVo) throws Exception {
		
		logger.debug("딜리트 CalendarVO : " + calendarVo.toString());
		
		int result = calenderService.calendarDelete(calendarVo);
		logger.debug("result : " + result);
		
		return "redirect:/common/calendar/calendarList";
		
	}
	
	
}
