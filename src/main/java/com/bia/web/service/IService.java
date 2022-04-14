package com.bia.web.service;

import java.util.List;

public interface IService<E> {

	public List<E> getAll();
	
	public void add(E object);
	
	public E getById(int id);
	
	public void update(E object);
	
	public void delete(int id);
}
