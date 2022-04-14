package com.bia.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.model.Student;
import com.bia.web.repository.StudentRepository;
import com.bia.web.service.StudentService;

/**
 * Servlet implementation class ListStudentController
 */
public class ListStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StudentRepository repo;
	StudentService studentService;
	
	public ListStudentController() {
		repo = new StudentRepository();
		studentService = new StudentService(repo);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		listStudents(request,response);
		
	}
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Student> students = studentService.getAll();
		
		request.setAttribute("STUDENT_LIST",students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/list-student.jsp");
		dispatcher.forward(request, response);
		
	}
}
