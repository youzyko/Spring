package com.springbook.view.borad;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class GetBoardListController implements Controller{
	

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println(" 글 목록 검색 처리");
		//DB연동
		BoardVO vo=new BoardVO();
		BoardDAO boardDAO=new BoardDAO();
		List<BoardVO> boardList=boardDAO.getBoardList(vo);
		
		//3.검색결과 세션에 저장 목록화면 리턴
		HttpSession session =request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
		
		
	}
		

}
