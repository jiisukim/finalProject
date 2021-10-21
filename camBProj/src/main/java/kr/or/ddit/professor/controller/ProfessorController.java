package kr.or.ddit.professor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProfessorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping("/professor/salary/salaryList")
	public String salaryList() {
		return "professor/salary/salaryList";
	}
	
	
	@RequestMapping("/professor/academic/academicList")
	public String academicList() {
		return "professor/academic/academicList";
	}
	
	@RequestMapping("/professor/consulting/test")
	public String testjsp() {
		return "professor/consulting/test";
	}
	
	
	
	
	
	
	
	
	
	
	
}
