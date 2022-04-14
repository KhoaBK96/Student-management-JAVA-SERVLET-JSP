package com.bia.web.service;

import java.util.List;

import com.bia.web.model.Student;
import com.bia.web.repository.IStudentRepository;

public class StudentService implements IStudentService{
	
	private IStudentRepository studentRepository;
	
	public StudentService(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.getAll();
	}

	@Override
	public void add(Student object) {
		studentRepository.add(object);
	}

	@Override
	public Student getById(int id) {
		return studentRepository.getById(id);
	}

	@Override
	public void update(Student object) {
		studentRepository.update(object);	
	}

	@Override
	public void delete(int id) {
		studentRepository.delete(id);
	}

}
