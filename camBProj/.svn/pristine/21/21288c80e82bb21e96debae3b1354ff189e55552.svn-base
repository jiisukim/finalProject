package kr.or.ddit.student.tuitionPayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.student.tuitionPayment.service.VrtAccntService;

/**
 * 가상 계좌
 * @author djs02
 */
@Controller
public class VrtAccntCodeController {

	@Autowired
	VrtAccntService vrtAccntService;

	/**
	 * 1000 개의 가상 계좌 생성 (1000개가 이미 생성되어 있으면 작동하지 않음)
	 */
	@RequestMapping("/vrtAccntCodeInsert")
	public void vrtAccntCodeInsert() {
		vrtAccntService.vrtAccntCodeInsert();
	}
}
