package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DispatchServlet
 */
/* @WebServlet(name = "action", urlPatterns = { "*.do" }) */
public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init()throws ServletException {
		handlerMapping=new HandlerMapping();
		viewResolver=new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		process(request,response);
	}


	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//1. 클라이언트 요청 path 정보추출
		String uri=request.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/"));
		
		//2.HandlerMapping을 통해 path에 해당하는 Controller 검색
		Controller ctrl =handlerMapping.getController(path);
		
		//3. 검색된 Controller를 실행한다 
		String viewName =ctrl.handleRequest(request, response) ;
	
		//4. ViewREsolver를 통해 viewName에 해당하는 화면 검색
		String view =null;
		if(! viewName.contains(".do")) {
			view=viewResolver.getView(viewName);
		}else {
			view=viewName;
		}
		
		//5. 검색화면으로 이동 
		response.sendRedirect(view);
		
	
			
		}
	}
	
		
	

	


