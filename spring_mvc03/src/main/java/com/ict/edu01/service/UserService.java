package com.ict.edu01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu01.repository.UserDAO;
import com.ict.edu01.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	
	public UserVO getUserSearch(String uname) {
		
		return userDAO.getUserSearch(uname);
	}
	
	
	

}


