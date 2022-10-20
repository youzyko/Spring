package com.springbook.biz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet  extends HttpServlet{

	public HelloServlet() {
		System.out.println("===>HelloSevelt 객체 생성");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doGet() 메소드 호출");
	}
	
}
