package com.sample.persistence.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.sample.common.IEntity;

@Transactional
public abstract class AbstractService<T extends IEntity> implements IService<T> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private final Class<T> clazz;

	public AbstractService(final Class<T> clazzToSet) {
		Preconditions.checkNotNull(clazzToSet);
		clazz = clazzToSet;
	}

	// find/get

	@Override
	public T findOne(final long id) {
		return getDao().findOne(id);
	}

	@Override
	public List<T> findAll() {
		return Lists.newArrayList(getDao().findAll());
	}

	// save/create/persist

	@Override
	public T save(final T entity) {
		final T persistedEntity = getDao().save(entity);

		return persistedEntity;
	}

	// delete

	@Override
	public void deleteAll() {
		getDao().deleteAll();
	}

	@Override
	public void delete(final List<T> entities) {
		getDao().delete(entities);
	}

	@Override
	public void delete(final long id) {
		getDao().delete(id);
	}

	//
	protected abstract JpaRepository<T, Long> getDao();

	public Class<T> getClazz() {
		return clazz;
	}

}
