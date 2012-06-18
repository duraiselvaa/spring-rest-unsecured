package com.sample.web.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.sample.common.IEntity;
import com.sample.persistence.common.service.IService;

public abstract class AbstractController<T extends IEntity> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	protected abstract IService<T> getService();

	// get/find

	protected final T findOneInternal(final Long id) {
		T entity = null;
		try {
			entity = this.getService().findOne(id);
		} catch (final InvalidDataAccessApiUsageException ex) {
			logger.error("", ex);
		}
		return entity;
	}

	protected final List<T> findAllInternal() {
		return this.getService().findAll();
	}

	// create/persist

	protected final void saveInternal(final T entity) {
		try {
			getService().save(entity);
		} catch (final IllegalStateException ex) {
			logger.error("", ex);
		} catch (final IllegalArgumentException ex) {
			logger.error("", ex);
		}
	}

	// update

	protected final void updateInternal(final T entity) {

		try {
			getService().save(entity);
		} catch (final InvalidDataAccessApiUsageException ex) {
			logger.error("", ex);
		}
	}

	// delete/remove

	protected final void deleteByIdInternal(final long id) {
		try {
			getService().delete(id);
		} catch (final InvalidDataAccessApiUsageException ex) {
			logger.error("", ex);
		}
	}

}
