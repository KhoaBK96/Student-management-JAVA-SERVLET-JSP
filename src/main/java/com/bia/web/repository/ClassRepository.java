package com.bia.web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bia.web.model.ClassRoom;
import com.bia.web.model.Student;

public class ClassRepository implements IClassRepository {

	@Override
	public List<ClassRoom> getAll() {
		
		List<ClassRoom> classes = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connection = DbConnectionProvider.getConnection();
			String sql = "Select id,name,teacher from class";
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String teacher = result.getString("teacher");
				
				ClassRoom tempClass = new ClassRoom(id, name, teacher);
				
				classes.add(tempClass);
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(connection, statement, result);
		}
		
		
		return classes;
	}

	@Override
	public void add(ClassRoom object) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		try {
			connection = DbConnectionProvider.getConnection();
			//create sql for insert
			String sql = "insert into class"
					+ "(name, teacher)"
					+ "values(?, ?)";
			
			statement = connection.prepareStatement(sql);
		
			//set the param values for the student
			statement.setString(1, object.getName());
			statement.setString(2, object.getTeacher());
		
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
	public ClassRoom getById(int id) {
		ClassRoom theClass = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = DbConnectionProvider.getConnection();
			String sql = "select id,name,teacher from class where id=" + id;
			statement =  connection.prepareStatement(sql);
			result = statement.executeQuery();
			if(result.next()) {
				String name = result.getString("name");
				String teacher = result.getString("teacher");
				
				theClass = new ClassRoom(id, name, teacher);
				
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
		finally {
			close(connection, statement, result);
		}
		return theClass;
	}

	@Override
	public void update(ClassRoom object) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = DbConnectionProvider.getConnection();
		
			String sql = "update class "
						+ "set name=?, teacher=? "
						+ "where id=?";
		
			statement = connection.prepareStatement(sql);
		
			statement.setString(1, object.getName());
			statement.setString(2, object.getTeacher());
			statement.setInt(3, object.getId());
		
			statement.execute();
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			close(connection, statement, null);
		}
		
	}

	@Override
	public void delete(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectionProvider.getConnection();
			
			String sql = "delete from class where id=?";
			
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
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
	
}
