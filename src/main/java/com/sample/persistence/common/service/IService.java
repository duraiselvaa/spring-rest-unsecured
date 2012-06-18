package com.sample.persistence.common.service;

import java.io.Serializable;
import java.util.List;

public interface IService<T extends Serializable> {

	// find/get

	T findOne(final long id);

	List<T> findAll();

	// save/create/persist

	T save(final T entity);

	// delete

	void delete(final long id);

	void delete(final List<T> entities);

	void deleteAll();

}
