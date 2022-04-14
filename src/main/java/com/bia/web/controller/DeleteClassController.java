package com.bia.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.repository.ClassRepository;
import com.bia.web.service.ClassService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class DeleteClassController
 */
public class DeleteClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	ClassRepository repo;
	ClassService classService;
	
	public DeleteClassController() {
		repo = new ClassRepository();
		classService = new ClassService(repo);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		classService.delete(id);
		
		response.sendRedirect(request.getContextPath()+"/ListClass");  
	}



}
