package com.rubypaper.board.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.board.domain.MemberVO;


public class SecurityUser  extends  User {
	
	private static final long serialVersionUID = 1L;

	public SecurityUser( MemberVO member) {
		 
		super(member.getId(),"{noop}" + member.getPassword(),
			   AuthorityUtils.createAuthorityList(member.getRole().toString())	);
	
		// 데이터베이스 리턴값.
		System.out.println(" ===> SecurityUser 생성자확인 ");
		System.out.println("===> SecurityUser 확인:" + member.getId()  + ":" + member.getPassword() );	
		
	}

}
