package com.ict.edu01.service;

import java.util.List;

import com.ict.edu01.vo.GuestBookVO;

public interface GuestBookService {
	
	public List<GuestBookVO> getGuestBookList();
	
	public int getGuestBookInsert(GuestBookVO gbvo);
	
	public GuestBookVO getGuestBookDetail(GuestBookVO gbvo);
	
	public int getGuestBookUpdate(GuestBookVO gbvo);
	
	public int getGuestBookDelete(GuestBookVO gbvo);
	
	

}
