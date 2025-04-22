package com.ict.edu02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu02.service.BookService;
import com.ict.edu02.service.CalcService;
import com.ict.edu02.vo.BookVO;
import com.ict.edu02.vo.CalcVO;
import com.ict.edu02.vo.MembersVO;


@Controller
public class Day2Controller {

	
	//@Autowired(Spring) 와 @inject(java)
	@Autowired
	private CalcService  calcService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/day02")
	public ModelAndView getForm() {
		/*
		 * servlet-context가서 <beans:bean
		 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		 * <beans:property name="prefix" value="/WEB-INF/views/" /> <beans:property
		 * name="suffix" value=".jsp" /> </beans:bean> 으로 우선 감
		 */
		return new ModelAndView("day02/input");
	}
	
	/*
	  @PostMapping("/logIn01") 
	  public ModelAndView getLogIn01(HttpServletRequest request) { 
	  ModelAndView mv = new ModelAndView(); 
	  String userId = request.getParameter("userId"); 
	  String userPw = request.getParameter("userPw");
	  
	  
	  mv.addObject("userId", userId); 
	  mv.addObject("userPw", userPw);
	  mv.setViewName("day02/result01"); 
	  return mv; 
	  }
	 */
	
	//vo
	/* HttpServletRequest request 안 쓰므로 위처럼 request못씀 */
	@PostMapping("/logIn01")
	public ModelAndView getLogIn01(MembersVO mvo) {
		ModelAndView mv = new ModelAndView();		
		
		
		// 원래는 DB 로그인 처리
		
		
		mv.addObject("userId", mvo.getUserId());
		mv.addObject("userPw", mvo.getUserPw());
		
		mv.addObject("mvo", mvo);
		
		mv.setViewName("day02/result01");
		return mv;
	}
	
	/*
	@GetMapping("/calc")
	public ModelAndView getCalc(CalcVO cvo) {
		ModelAndView mv = new ModelAndView();
		
		//여기서 해도 되지만 service에서 하자
		
		int su1 = Integer.parseInt(cvo.getS1());
		int su2 = Integer.parseInt(cvo.getS2());
		
		int result = 0;
		
		
		switch(cvo.getOp()) {
		case "+": result = su1 + su2; break;
		case "-": result = su1 - su2; break;
		case "*": result = su1 * su2; break;
		case "/": result = su1 / su2; break;
		
		}
		
		
		//CalcService calcService = new CalcService();
		int result = calcService.getCalc(cvo);
		mv.addObject("cvo", cvo);
		mv.addObject("result", result);
		
		
		mv.setViewName("day02/result02");
		return mv;
	}*/
	
	
	@GetMapping("/calc")
	public ModelAndView getCalc(@ModelAttribute("cvo") CalcVO cvo2) {
		ModelAndView mv = new ModelAndView();
		// @ModelAttribute("cvo") :  클라이언트 요청의 파라미터를 자바 객체에  자동 바인딩 역할
		//여기서 해도 되지만 service에서 하자
		/*
		int su1 = Integer.parseInt(cvo.getS1());
		int su2 = Integer.parseInt(cvo.getS2());
		
		int result = 0;
		
		
		switch(cvo.getOp()) {
		case "+": result = su1 + su2; break;
		case "-": result = su1 - su2; break;
		case "*": result = su1 * su2; break;
		case "/": result = su1 / su2; break;
		
		}
		 */
		
		//CalcService calcService = new CalcService();
		int result = calcService.getCalc(cvo2);
		// mv.addObject("cvo", cvo); 이 한줄 안쓰기 위해
		// 	public ModelAndView getCalc(@ModelAttribute("cvo") CalcVO cvo) 
		// 에다가 @ModelAttribute("cvo") 추가한것
		
		
		//@ModelAttribute("cvo") 
		//mv.addObject("cvo", cvo);
		mv.addObject("result", result);
		
		
		mv.setViewName("day02/result02");
		return mv;
	}
	
	@RequestMapping("/hobby")
	public ModelAndView getHobby(@ModelAttribute("cvo") CalcVO cvo) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("day02/result03");
		
		return mv;
		
	}
	
	@RequestMapping("/bookList")
	public ModelAndView getBookList() {
		ModelAndView mv = new ModelAndView();
		List<BookVO> list = bookService.getBookList();
		mv.addObject("list", list);
		mv.setViewName("day02/result04");
		return mv;
		
		
	}
	
	
	
	@GetMapping("/bookdetail")
	public ModelAndView getBookDetail(BookVO bvo) {
		ModelAndView mv = new ModelAndView();
		BookVO bookvo = bookService.getBookDetail(bvo);
		
		mv.addObject("bvo", bookvo);
		mv.setViewName("day02/result05");
		
		return mv;
	}
	
	@GetMapping("/bookdelete")
	public ModelAndView getBookDelete(BookVO bvo) {
		ModelAndView mv = new ModelAndView();
		
		
		// servlet-context.xml에 리턴 후 redirect 때문에 
		// servlet-context.xml와서 /bookList를 찾아 간다.
		
		int result = bookService.getBookDelete(bvo);
		//mv.setViewName("forward:/bookList");
		
		mv.setViewName("redirect:/bookList");
		return mv;
		
		/*
		 * 우선 return servlet로 감. 거기서 redurect로 감.redirect는 클라이언트갔다가 다시 servlet 옴 그러면서 정보가 다
		 * 날라감(request, response다 날라감) 그리고 이게 redirect뒤에 있는 booklist로
		 * 감. 근데 annotation되어있으므로 즉 이파일에 있는 /booklist로 감 
		 * 
		 * get 방식-> get 상관없이
		 * redirect가 get..?  post일때는 get으로 못가나..? 암튼 그래서 getMapping이나 postMapping않고 requestMapping으로 감
		 */
		
	}
	
	
	
	@GetMapping("/bookupdate")
	public ModelAndView getBookUpdate(BookVO bvo) {
		ModelAndView mv = new ModelAndView();
		BookVO bookvo = bookService.getBookDetail(bvo);
		mv.addObject("bvo", bookvo);
		
		mv.setViewName("day02/result06");
		return mv;
		
		
	}
	
	
	@PostMapping("/bookupdate_ok")
	public ModelAndView getBookUpdate_ok(BookVO bvo) {
		ModelAndView mv = new ModelAndView();
		int result = bookService.getBookUpdate_ok(bvo);
		
		/*
		 * 아래 bookdetail?bookid="+ 이부분이 get방식 post방식은 requestmapping
		 */		
		mv.setViewName("redirect:/bookdetail?bookid="+bvo.getBookid());
		return mv;
		
		
	}
	
}
