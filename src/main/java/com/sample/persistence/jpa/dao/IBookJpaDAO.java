package com.sample.persistence.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.persistence.common.entity.Book;

public interface IBookJpaDAO extends JpaRepository<Book, Long> {
	//
}
