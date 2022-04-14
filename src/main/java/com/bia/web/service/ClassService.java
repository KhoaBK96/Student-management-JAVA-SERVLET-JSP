package com.bia.web.service;

import java.util.List;

import com.bia.web.model.ClassRoom;
import com.bia.web.repository.IClassRepository;

public class ClassService implements IClassService{
	
	IClassRepository classRepository;
				
	public ClassService(IClassRepository classRepository) {
		this.classRepository = classRepository;
	}

	@Override
	public List<ClassRoom> getAll() {
		return	classRepository.getAll();
	}

	@Override
	public void add(ClassRoom object) {
		 classRepository.add(object);
		
	}

	@Override
	public ClassRoom getById(int id) {
		return classRepository.getById(id);
	}

	@Override
	public void update(ClassRoom object) {
		classRepository.update(object);
		
	}

	@Override
	public void delete(int id) {
		classRepository.delete(id);
		
	}

}
