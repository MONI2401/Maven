package com.capg.book.service;

import static com.capg.book.util.Constants.LOGGER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.book.dao.IBookRepository;
import com.capg.book.model.Book;

@Service("service")
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository BookRepo;

//	@Override
//	public BookDTO addBook(Book Book) {
//		LOGGER.info("addBook Method executed in Service");
//		Book addBook = BookRepo.save(Book);
//		return mapper.bookToBookDto(addBook);
//	}

	@Override
	public Book getBook(int id) {
		LOGGER.info("getBook Method executed in Service");
		Book getBook = BookRepo.findById(id).orElse(null);
		return getBook;
	}

	@Override
	public List<Book> findAllBook() {
		LOGGER.info("getting All records from database");
		return BookRepo.findAll();
	}

	@Override
	public void deleteBook(Integer id) {
		BookRepo.deleteById(id);

	}

	@Override
	public Book updateBook(Book book) {
		BookRepo.updateBook(book.getId(), book.getTitle(), book.getDescription());
		LOGGER.info("Updated book redord");
		return book;
	}

}
