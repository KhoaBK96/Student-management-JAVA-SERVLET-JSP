package com.bia.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.model.Student;
import com.bia.web.repository.StudentRepository;
import com.bia.web.service.StudentService;

/**
 * Servlet implementation class GetStudentController
 */
public class GetStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	StudentRepository repo;
	StudentService studentService;
	
	

	public GetStudentController(){
		repo = new StudentRepository();
		studentService = new StudentService(repo);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getStudent(request,response);
	}
	private void getStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		//lay student
		Student theStudent = studentService.getById(id);
		
		request.setAttribute("showStudent", theStudent);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/GetStudent.jsp");
		dispatcher.forward(request, response);
		
	}

}
