package com.ict.edu07.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ict.edu07.service.EmailService;

@RestController
public class AjaxEmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendCode")
	@ResponseBody
	public String sendCode(@RequestParam("email") String email,
			HttpServletRequest request) {
		try {
			String code = emailService.sendAuthMail(email);
			
			// 코드를 세션(브라우저 닫힐 때까지 정보 가지고 있음)에 저장하자 왜?
			request.getSession().setAttribute("authCode", code);
			request.getSession().setAttribute("authTime", System.currentTimeMillis());// 인증 시간 기록
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
		
	}
	@PostMapping("/verifyCode")
	@ResponseBody
	public String verifyCode(@RequestParam("code") String code,
			HttpServletRequest request) {
		
		// 세션에 저장되어 있는 authCode와 authTime를 호출해서 
		// 파라미터의 code 비교하고 시간도 비교해서 5분을 초과하면 오류
		
		String saveCode = (String) request.getSession().getAttribute("authCode");
		long saveTime = (Long) request.getSession().getAttribute("authTime");
		
		long curTime = System.currentTimeMillis();
		if(saveCode == null || saveTime == 0) return "no_code";
		if((curTime - saveTime) > 1000 * 60 * 5) return "expired";
		if(saveCode.equals(code)) {
			return "match";
		}else {
			return "mismatch";
		}

	}
	
	/* service는 db가는 것도 있고 안 가는 것도 있음 */
	
	/*
	 * @PostMapping("/sendCode2")
	 * 
	 * @ResponseBody public String sendCode2(
	 * 
	 * @ModelAttribute("email") String email, HttpSession session) {
	 * 
	 * 
	 * }
	 */
	
	
	
	
}
