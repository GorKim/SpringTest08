package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.persistence.BoardServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {

	@Autowired
	private BoardServiceImpl  service;
	
	@Before
	public  void  insert() {
		for(int i=1; i <=3 ; i++) {
		BoardVO	vo=new BoardVO();
		vo.setTitle("너구리"+i+"입니다.");
		vo.setWriter("ppk");
		vo.setContent("너구리내용"+i+"");
		vo.setCreateDate(new Date());
		vo.setCnt(4);
		service.insert(vo);
		}
		
	}
	
	// @Before
	public  void  delete() {
		for (int i=1 ; i <= 10 ; i++ ) {
		BoardVO	vo=new BoardVO();
		vo.setSeq(1001 + i);
		service.delete(vo);
		}
		
	}
	
	@Test
	public  void  select() {
		
		List<BoardVO> li=service.getBoardList(null);
		
		for(BoardVO m :li) {
		  System.out.println("==>" + m.toString());
		}
	}

	
}
