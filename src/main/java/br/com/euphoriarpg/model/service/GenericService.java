package br.com.euphoriarpg.model.service;

import java.util.List;

public interface GenericService<E,D> {
	
	List<E> getAll();

	E create(D dado);

	E update(Long id, D dado);

	void delete(Long id);

	E getById(Long id);

	void delete(Long id, String usuario);

}
