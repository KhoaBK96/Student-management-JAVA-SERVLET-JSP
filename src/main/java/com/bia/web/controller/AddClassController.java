package com.bia.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.model.ClassRoom;
import com.bia.web.model.Student;
import com.bia.web.repository.ClassRepository;
import com.bia.web.service.ClassService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class AddClassController
 */
public class AddClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	ClassRepository repo;
	ClassService classService;
	
	public AddClassController() {
		repo = new ClassRepository();
		classService = new ClassService(repo);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		loadClass(request,response);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/add-class-form.jsp");
		dispatcher.forward(request, response);
	}

	
	private void loadClass(HttpServletRequest request, HttpServletResponse response) {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		ClassRoom loadClass = new ClassRoom();
		
		if(id > 0) {
			loadClass = classService.getById(id);
		}
		
		//tao atribute student
		request.setAttribute("UPDATE_CLASS", loadClass);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateClass(request,response);
	}

	private void updateClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberTools.parseIntWithFallback(request.getParameter("id"));
		String name = request.getParameter("name");
		String teacher = request.getParameter("teacher");
	
		
		ClassRoom updateClass = new ClassRoom(id, name, teacher);
		
		if(id >= 1) {	
			classService.update(updateClass);
		}else {
			classService.add(updateClass);
		}
		
		response.sendRedirect(request.getContextPath()+"/ListClass"); 
		
	}

}
