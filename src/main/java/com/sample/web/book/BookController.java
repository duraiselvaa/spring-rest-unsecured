package com.sample.web.book;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sample.persistence.common.entity.Book;
import com.sample.persistence.common.service.IService;
import com.sample.persistence.common.service.book.IBookService;
import com.sample.web.common.AbstractController;

@Controller
public class BookController extends AbstractController<Book> {

	@Autowired
	private IBookService bookService;

	// API

	// get/find

	@RequestMapping(method = RequestMethod.GET, value = "/book/{id}")
	@ResponseBody
	public Book findOne(@PathVariable("id") final Long id) {
		return findOneInternal(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/book")
	@ResponseBody
	public List<Book> findAll() {
		return findAllInternal();
	}

	// create/persist

	@RequestMapping(method = RequestMethod.POST, value = "/book")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody final Book entity,
			final HttpServletResponse response) {
		saveInternal(entity);
		response.setHeader("Book", "/book/" + entity.getId());
	}

	// update

	@RequestMapping(method = RequestMethod.PUT, value = "/book")
	@ResponseBody
	public void update(@RequestBody final Book entity) {
		updateInternal(entity);
	}

	// delete/remove

	@RequestMapping(method = RequestMethod.DELETE, value = "/book/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") long id) {
		deleteByIdInternal(id);
	}

	//

	@Override
	protected IService<Book> getService() {
		return bookService;
	}

}
