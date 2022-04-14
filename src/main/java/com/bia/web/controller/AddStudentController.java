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
import com.bia.web.repository.StudentRepository;
import com.bia.web.service.ClassService;
import com.bia.web.service.StudentService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class AddStudentController
 */
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentRepository studentRepo;
	StudentService studentService;
	ClassRepository classRepo;
	ClassService classService;
	
	
	public AddStudentController() {
		studentRepo = new StudentRepository();
		studentService = new StudentService(studentRepo);
		classRepo = new ClassRepository();
		classService = new ClassService(classRepo);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		loadStudent(request,response);
		listClass(request,response);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/add-student-form.jsp");
		dispatcher.forward(request, response);
			
	}
	
	private void listClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ClassRoom> classes = classService.getAll();
		
		request.setAttribute("CLASS_LIST",classes);
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) {
		// lay ID tu request parameter
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		Student loadStudent = new Student();
		
		if(id > 0) {
			loadStudent = studentService.getById(id);
		}
		
		//tao atribute student
		request.setAttribute("UPDATE_STUDENT", loadStudent);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		updateStudent(request,response);
	}
		
	
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int classRoomId =  NumberTools.parseIntWithFallback(request.getParameter("classRoomId"));
		ClassRoom classRoom = new ClassRoom(classRoomId);
		Student updateStudent = new Student(id, firstName, lastName, email, classRoom);
		
		if(id >= 1) {	
			studentService.update(updateStudent);
		}else {
			studentService.add(updateStudent);
		}
		
		response.sendRedirect(request.getContextPath()+"/");  
	}
}
