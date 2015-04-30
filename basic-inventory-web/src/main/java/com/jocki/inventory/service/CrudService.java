package com.jocki.inventory.service;

public interface CrudService<T> {

	public T newInstance();
	
	public T simpan(T entity);
	
	public T update(T entity);
	
	public void hapus(T entity);
	
}
