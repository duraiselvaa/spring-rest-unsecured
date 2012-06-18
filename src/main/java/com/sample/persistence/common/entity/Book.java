package com.sample.persistence.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sample.common.IEntity;

@Entity
@Table(name = "book")
@XmlRootElement(name = "book")
public class Book implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private String publication;

	public Book() {
		super();
	}

	public Book(String name, String author, String publication) {
		this.name = name;
		this.author = author;
		this.publication = publication;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		final Book other = (Book) obj;

		if (!(other.getName().equals(this.name))) {
			return false;
		}

		if (!(other.getAuthor().equals(this.author))) {
			return false;
		}

		if (!(other.getPublication().equals(this.publication))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
