package com.bia.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.model.ClassRoom;
import com.bia.web.model.Student;
import com.bia.web.repository.ClassRepository;
import com.bia.web.service.ClassService;

/**
 * Servlet implementation class ListClassController
 */
public class ListClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClassRepository repo;
	ClassService classService;
	
	public ListClassController() {
		repo = new ClassRepository();
		classService = new ClassService(repo);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		listClass(request,response);
		
	}

	private void listClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ClassRoom> classes = classService.getAll();
		
		request.setAttribute("CLASS_LIST",classes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/list-classes.jsp");
		dispatcher.forward(request, response);	
		
	}

	

}
