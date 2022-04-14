package com.bia.web.repository;

import java.util.List;

import com.bia.web.model.ClassRoom;

public interface IRepository<E> {
	
	public List<E> getAll();
	
	public void add(E object);
	
	public E getById(int id);
	
	public void update(E object);
	
	public void delete(int id);

}
