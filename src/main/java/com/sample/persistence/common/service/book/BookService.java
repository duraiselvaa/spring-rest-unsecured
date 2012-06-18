package com.sample.persistence.common.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.persistence.common.entity.Book;
import com.sample.persistence.common.service.AbstractService;
import com.sample.persistence.jpa.dao.IBookJpaDAO;

@Service
class BookService extends AbstractService<Book> implements IBookService {

	@Autowired
	IBookJpaDAO dao;

	public BookService() {
		super(Book.class);
	}

	// No Specific API to override at the moment

	@Override
	protected final IBookJpaDAO getDao() {
		return dao;
	}

}
