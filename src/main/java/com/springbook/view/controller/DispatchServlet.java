package com.springbook.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatchServlet
 */
@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		process(request,response);
	}


	private void process(HttpServletRequest request, HttpServletResponse response) {
		String uri=request.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2.틀라이언트 요청 path에따라 적절히 분기처리
		if(path.equals("/login.do")) {
			System.out.println("로그인처리");
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아아웃처리");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("로그아아웃처리");
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("글삭제");
		}else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세조회");
		}else if(path.equals("/getBoarList.do")) {
			System.out.println("글 목록 검색 처리");
		}
		
	}

	

}
