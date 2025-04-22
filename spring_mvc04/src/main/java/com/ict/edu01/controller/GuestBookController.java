package com.ict.edu01.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu01.service.GuestBookService;
import com.ict.edu01.vo.GuestBookVO;

@Controller
public class GuestBookController {
	
	
	@Autowired
	private GuestBookService guestBookService;
	
	@GetMapping("/day03")
	public ModelAndView getFileuploadForm() {
		
		return new ModelAndView("day03/uploadForm");
	}
	
	
	@GetMapping("/guestBookList")
	public ModelAndView getGuestBookList() {
		
		ModelAndView mv = new ModelAndView();
		List<GuestBookVO> list = guestBookService.getGuestBookList();
		mv.addObject("list", list);
		mv.setViewName("day03/list");
		return mv;
		
	}
	
	
	@GetMapping("/guestBookDetail")
	public ModelAndView getGuestBookDetail(GuestBookVO gbvo) {
		try {
			
			ModelAndView mv = new ModelAndView();
			GuestBookVO gvo = guestBookService.getGuestBookDetail(gbvo);
			if(gvo !=null) {
				
				mv.addObject("gvo", gvo);
				mv.setViewName("day03/onelist");
				return mv;
				
			}
			
			return new ModelAndView("day03/error");
			
		} catch (Exception e) {
			return new ModelAndView("day03/error");
		}
		
		
	}
	
	@GetMapping("/guestBookDown")
	public void guestBookDown(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			String f_name = request.getParameter("f_name");
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + f_name);
			String r_path = URLEncoder.encode(f_name, "UTF-8");
			
			
			
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition",  "attachment;filename=" + r_path);
			
			
			File file = new File(new String(path.getBytes(), "utf-8"));
			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(in, out);
			response.getOutputStream().flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	@GetMapping("/guestBookWrite")
	public ModelAndView guestBookWrite() {
		
		return new ModelAndView("day02/write");
	}
	
	
	@PostMapping("/guestBookWriteOK")
	public ModelAndView guestBookWriteOK(GuestBookVO gbvo,
			HttpServletRequest request) {
		try {
			ModelAndView mv = new ModelAndView();
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/");
			MultipartFile file = gbvo.getGb_file_name();
			if(file.isEmpty()) {
				
				gbvo.setGb_f_name("");
			}else {
				
				UUID uuid = UUID.randomUUID();
				String f_name = uuid.toString() + "_" + file.getOriginalFilename();
				gbvo.setGb_f_name(f_name);
				
				file.transferTo(new File(path, f_name));
				
				
			}
			
			
			int result = guestBookService.getGuestBookInsert(gbvo);
			if(result > 0) {
				
				mv.setViewName("redirect:/guestBookList");
				return mv;
			}
			
			return new ModelAndView("day03/error");
		} catch (Exception e) {
			return new ModelAndView("day03/error");
		}
		
		
	}
	
	@GetMapping("/guestBookDelete")
	public ModelAndView guestBookDelete(GuestBookVO gbvo) {
		try {
			
			ModelAndView mv = new ModelAndView();
			
			
			GuestBookVO gvo = guestBookService.getGuestBookDetail(gbvo);
			
			if(gvo != null) {
				
				
				
				mv.addObject("gvo", gvo);
				mv.setViewName("day03/delete");
				return mv;
			}
			
			return new ModelAndView("day03/error");
			
		} catch (Exception e) {
			return new ModelAndView("day03/error");
		}
	}
	
	
	@PostMapping("/guestBookDeleteOK")
	public ModelAndView guestBookDeleteOK(GuestBookVO gbvo) {
		try {
			ModelAndView mv = new ModelAndView();
			int result = guestBookService.getGuestBookDelete(gbvo);
			if(result > 0) {
				mv.setViewName("redirect:/guestBookList");
				return mv;
				
			}
			return new ModelAndView("day02/error");
			
			
		}catch (Exception e) {
			return new ModelAndView("day02/error");
		}
		
	}
	
	@GetMapping("/guestBookUpdate")
	public ModelAndView guestBookUpdate(GuestBookVO gbvo) {
		try {
			
			ModelAndView mv = new ModelAndView();
			
			
			GuestBookVO gvo = guestBookService.getGuestBookDetail(gbvo);
			
			if(gvo != null) {
				
				
				
				mv.addObject("gvo", gvo);
				mv.setViewName("day03/update");
				return mv;
			}
			
			return new ModelAndView("day03/error");
			
		} catch (Exception e) {
			return new ModelAndView("day03/error");
		}
	}
	
	@PostMapping("/guestBookUpdateOK")
	public ModelAndView guestBookUpdateOK(GuestBookVO gbvo, HttpServletRequest request) {
		
		try {
			ModelAndView mv = new ModelAndView();
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/");
			MultipartFile file = gbvo.getGb_file_name();
			if(file.isEmpty()) {
				
				gbvo.setGb_f_name(gbvo.getGb_old_f_name());
			}else {
				
				UUID uuid = UUID.randomUUID();
				String f_name = uuid.toString() + "_" + file.getOriginalFilename();
				gbvo.setGb_f_name(f_name);
				file.transferTo(new File(path, f_name));
			}
			
			
			
			int result = guestBookService.getGuestBookUpdate(gbvo);
			if(result > 0) {
				
				mv.setViewName("redirect:/guestBookDetail?gb_idx=" + gbvo.getGb_idx());
				return mv;
			}
			
			
			return new ModelAndView("day03/error");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("day03/error");
			
		}
	}
	
	
	
	
	
	

}
