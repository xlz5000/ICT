package com.ict.edu01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu01.service.UserService;
import com.ict.edu01.vo.UserVO;


@Controller
public class Day0Controller {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/day00")
	public ModelAndView getForm() {
		
		
		return new ModelAndView("day00/input");
	}
	
	@GetMapping("/search")
	public ModelAndView getUserSearch(HttpServletRequest request) {
		
		String uname = request.getParameter("uname");
		ModelAndView mv = new ModelAndView();
		UserVO uservo = userService.getUserSearch(uname);
		
		mv.addObject("uvo", uservo);
		mv.setViewName("day00/result00");
		
		return mv;
		
	}
	
	

	

}





