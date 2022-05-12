package com.capg.book.service;

import java.util.List;

import com.capg.book.model.Book;

public interface IBookService {
	public List<Book> findAllBook();
	public void deleteBook(Integer id);
	public Book updateBook(Book book);
	public Book getBook(int id);

	

}
