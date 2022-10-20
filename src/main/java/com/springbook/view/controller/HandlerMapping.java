package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.borad.GetBoardListController;
import com.springbook.view.user.LoginController;

public class HandlerMapping {
	private Map <String, Controller> mappings;
	
	public HandlerMapping() {
		mappings=new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoarList.do",new GetBoardListController());
	}
	public Controller getController(String path ) {
		return mappings.get(path);
	}
}
