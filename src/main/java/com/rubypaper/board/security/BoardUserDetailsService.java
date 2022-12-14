package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.persistence.MemberDao;



@Service
public class BoardUserDetailsService  implements  UserDetailsService {

	BoardUserDetailsService(){
	 System.out.println("===> BoardUserDetailsService 생성자확인");
	}
	
	@Autowired
	private MemberDao  dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			   throws UsernameNotFoundException {
		
		System.out.println("===> UserDetails loadUserByUsername ");
		
		// login 폼에서 넘어온값 
		MemberVO member = new MemberVO();
		member.setId(username);
	
		MemberVO user = dao.getMember(member);
		System.out.println("확인:" +user);
		
		if(user == null) {
			throw  new  UsernameNotFoundException(username + "사용자 없음");
		}else {
			System.out.println(" ===****==> new SecurityUser 로 넘어간다.");
			return new SecurityUser(user);
		}


	}

}
