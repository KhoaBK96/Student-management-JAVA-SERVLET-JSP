package com.bia.web.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bia.web.model.ClassRoom;
import com.bia.web.model.Student;

public class StudentRepository implements IStudentRepository {

	
	@Override
	public List<Student> getAll() {
		
		List<Student> students = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connection = DbConnectionProvider.getConnection();
			String sql = "SELECT st.id, st.first_name, st.last_name, st.email, st.classRoomId, cl.name, cl.teacher\r\n"
					+ "FROM student.student st \r\n"
					+ "INNER JOIN student.class cl \r\n"
					+ "ON st.classRoomId = cl.id";
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				int classRoomId = result.getInt("classRoomId");
				String className = result.getString("name");
				String teacher = result.getString("teacher");
						
				Student tempStudent = new Student(id, firstName, lastName, email);
				ClassRoom tempClassRoom = new ClassRoom (classRoomId, className, teacher);
				
				tempStudent.setClassRoom(tempClassRoom);
				students.add(tempStudent);
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(connection, statement, result);
		}
		
		
		return students;
	}

	@Override
	public void add(Student object) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		try {
			connection = DbConnectionProvider.getConnection();
			//create sql for insert
			String sql = "insert into student"
					+ "(first_name, last_name, email, classRoomId)"
					+ "values(?, ?, ?, ?)";
			
			statement = connection.prepareStatement(sql);
		
			//set the param values for the student
			statement.setString(1, object.getFirstName());
			statement.setString(2, object.getLastName());
			statement.setString(3, object.getEmail());
			statement.setInt(4, object.getClassRoom().getId());
			//execute sql insert
			statement.execute();
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			//clean up JDBC object
			close(connection, statement, null);
		}
	}

	@Override
	public Student getById(int id) {
		
		Student theStudent = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = DbConnectionProvider.getConnection();
			String sql = "select id,first_name,last_name,email from student where id=" + id;
			statement =  connection.prepareStatement(sql);
			result = statement.executeQuery();
			if(result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				
				theStudent = new Student(id, firstName, lastName, email);
				
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
		finally {
			close(connection, statement, result);
		}
		return theStudent;
	
	}
	
	@Override
	public void update(Student object) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = DbConnectionProvider.getConnection();
		
			String sql = "update student "
						+ "set first_name=?, last_name=?, email=?, classRoomId=? "
						+ "where id=?";
		
			statement = connection.prepareStatement(sql);
		
			statement.setString(1, object.getFirstName());
			statement.setString(2, object.getLastName());
			statement.setString(3, object.getEmail());
			statement.setInt(4, object.getClassRoom().getId());
			statement.setInt(5, object.getId());
		
			statement.execute();
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			close(connection, statement, null);
		}
	}
	
	private void close(Connection connection, Statement statement, ResultSet result)  {
		try{
			if(connection != null) {
			}
			connection.close();
		
			if(statement != null) {
			statement.close();
			}
			if(result != null) {
			result.close();
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectionProvider.getConnection();
			
			String sql = "delete from student where id=?";
			
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			statement.execute();
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			close(connection, statement, null);
		}
	}
	
	
}
