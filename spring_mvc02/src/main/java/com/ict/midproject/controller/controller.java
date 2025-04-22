package com.ict.midproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {

	
		@GetMapping("/main_dept")
		public ModelAndView getMainDept() {
			
			return new ModelAndView("midproject/main_dept");
		}
}
