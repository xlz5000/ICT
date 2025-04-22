package com.ict.edu03.controller;

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

import com.ict.edu03.service.GuestBookService;
import com.ict.edu03.vo.GuestBookVO;

@Controller
public class GuestBookController {

	
	@Autowired
	private GuestBookService guestBookService;
	
	
	
	@GetMapping("/guestBookList")
	public ModelAndView getGuestBookList() {
		
		ModelAndView mv = new ModelAndView();
		List<GuestBookVO> list = guestBookService.getGuestBookList();
		mv.addObject("list", list);
		mv.setViewName("day03/list");
		return mv;
		
	}
	
	@GetMapping("/guestBookWrite")
	public ModelAndView guestBookWrite() {
		
		return new ModelAndView("day03/write");
		
		
	}
	
	@PostMapping("/guestBookWriteOK")
	public ModelAndView guestBookWriteOk(GuestBookVO gbvo, 
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
				// 실제 파일 업로드
				file.transferTo(new File(path, f_name));
				
			}
			
			// 비밀번호 암호화(다음에)
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
	
	
	@GetMapping("/guestBookDetail")
	public ModelAndView guestBookDetail(GuestBookVO gbvo) {
		try {
			
			ModelAndView mv = new ModelAndView();
			GuestBookVO gvo = guestBookService.getGuestBookDetail(gbvo);
			if(gvo != null) {
				
				
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
			// 서버의 파일 시스템 상에서 파일이 저장된 실제 경로를 얻는 코드
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + f_name);
			String r_path = URLEncoder.encode(f_name, "UTF-8");
			
			
			// 브라우저 설정(response)
			// 웹 브라우저에서 파일을 다운로드하도록 지시하는 MIME 타입, 브라우저가 해당 응답을 파일로 취급하도록 함
			response.setContentType("application/x-msdownload");
			// Content-Disposition은 응답 해더, "attachment; filename="브라우저가 이 응답을 다운로드로 처리하도록 저장
			// 즉 아래코드는 브라우저에게 이 응답을 파일로 저장하라는 지시를 내리며, 다운로드 할 파일 이름을 설정함
			response.setHeader("Content-Disposition", "attachment; filename=" + r_path);
			
			
			// 실제 입출력
			File file = new File(new String(path.getBytes(), "utf-8"));
			FileInputStream in = new FileInputStream(file);// 파일을 읽을 준비
			OutputStream out = response.getOutputStream(); // 응답의 출력 스트림을 얻어 클라이언트에게 데이터를 보낼 준비를 함.
			FileCopyUtils.copy(in, out); // in에서 읽은 데이터를 out으로 복사 즉 서버에서 읽은 파일 데이터를 클라이언트로 전송
			// 응답을 강제로 플러시 하여 출력 스트림에 있는 모든 데이터를 클라이언트에게 전송
			//flush()메서드는 스트림의 버퍼를 비우고, 아직 전송되지 않은 데이터를 클라이언트로 즉시 전송하는 역할을 함.
			response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/guestBookDelete")
	public ModelAndView guestBookDelete(GuestBookVO gbvo) {
		try {
			
			ModelAndView mv = new ModelAndView();
			
			GuestBookVO gvo = guestBookService.getGuestBookDetail(gbvo);
			if(gvo != null) {
				
				//delete.jsp에서 gb_pw와 gb_idx를 사용해야 된다.
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
	public ModelAndView guestBookDeleteOk(GuestBookVO gbvo) {
		
		try {
			ModelAndView mv =  new ModelAndView();
			int result = guestBookService.getGuestBookDelete(gbvo);
			if(result > 0) {
				mv.setViewName("redirect:/guestBookList");
				return mv;
			}
			return new ModelAndView();
			//return new ModelAndView("day03/error");
			
		}catch (Exception e) {
			
			return new ModelAndView("day03/error");
		}
	}
	
	@GetMapping("/guestBookUpdate")
	public ModelAndView guestBookUpdate(GuestBookVO gbvo) {
		try {
			
			ModelAndView mv = new ModelAndView();
			
			GuestBookVO gvo = guestBookService.getGuestBookDetail(gbvo);
			if(gvo != null) {
				
				//delete.jsp에서 gb_pw와 gb_idx를 사용해야 된다.
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
	public ModelAndView guestBookUpdateOK(GuestBookVO gbvo, HttpServletRequest request){
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
				// 실제 파일 업로드
				file.transferTo(new File(path, f_name));
				
			}
			
			int result = guestBookService.getGuestBookUpdate(gbvo);
			if(result>0) {
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
