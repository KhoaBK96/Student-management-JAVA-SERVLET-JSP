package com.bia.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.repository.StudentRepository;
import com.bia.web.service.StudentService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class DeleteStudentController
 */
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentRepository repo;
	StudentService studentService;
	
	

	public DeleteStudentController() {
		repo = new StudentRepository();
		studentService = new StudentService(repo);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		studentService.delete(id);
		
		response.sendRedirect(request.getContextPath()+"/");  
	}



}
