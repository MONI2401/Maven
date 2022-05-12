package com.capg.book.controller;

import static com.capg.book.util.Constants.LOGGER;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartFile;

import com.capg.book.dao.IBookRepository;
import com.capg.book.model.Book;
import com.capg.book.service.IBookService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.common.record.Record;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookController {

	@Autowired
	public IBookService service;
	@Autowired
	public IBookRepository repo;

	@PostMapping("/addBook")
	public String uploadData(@RequestParam("file") MultipartFile file) throws Exception {
		List<Book> booklist = new ArrayList<>();
		InputStream inputStream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
		parseAllRecords.forEach(record -> {
			Book book = new Book();
			book.setTitle(record.getString("Title"));
			book.setDescription(record.getString("Description"));
			book.setAuthID(record.getString("AuthID"));
			book.setGenre(record.getString("Genre"));
			book.setFirstName(record.getString("FirstName"));
			book.setLastName(record.getString("LastName"));
			book.setBirthday(record.getString("Birthday"));
			book.setCountryofResidence(record.getString("CountryofResidence"));
			book.setCheckoutMonth(record.getString("CheckoutMonth"));
			book.setNumberofCheckouts(record.getString("NumberofCheckouts"));
			book.setFormat(record.getString("Format"));
			book.setPubID(record.getString("PubID"));
			book.setPublicationDate(record.getString("PublicationDate"));
			book.setPages(record.getString("Pages"));
			book.setRating(record.getString("Rating"));
			book.setReviewerID(record.getString("ReviewerID"));
			book.setReviewID(record.getString("ReviewID"));
			book.setPrintRunSize(record.getString("PrintRunSize"));
			book.setPrice(record.getString("Price"));
			book.setISBN(record.getString("ISBN"));
			book.setDiscount(record.getString("Discount"));
			book.setItemID(record.getString("ItemID"));
			book.setOrderID(record.getString("OrderID"));
			book.setSaleDate(record.getString("SaleDate"));
			
			booklist.add(book);
			
		});
		repo.saveAll(booklist);
		return "Added Successfully !!!";
	}
//	public ResponseEntity<BookDTO> addBook(@RequestBody Book Book) {
//		try {
//			LOGGER.info("addBook method is initialed");
//			BookDTO addedBook = service.addBook(Book);
//			return new ResponseEntity<BookDTO>(addedBook, HttpStatus.OK);
//		}
//
//		catch (Exception e) {
//			LOGGER.warn("OOPS! Check details entered");
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@GetMapping("/getBook/{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id) {
		try {
			LOGGER.info("getBook method is initialed");
			Book resultBook = service.getBook(id);
			return new ResponseEntity<Book>(resultBook, HttpStatus.OK);
		}

		catch (Exception e) {
			LOGGER.warn("OOPS! No Books in database.");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAll")
	public List<Book> findAllBook() {
		return service.findAllBook();
	}

	@PutMapping("/book/id/{id}")
	public Book updateBook(@RequestBody Book book) {
		return service.updateBook(book);
	}

	@DeleteMapping(value = "/delete/id/{id}")
	public Map<String, Boolean> deleteById(@PathVariable int id) {
		service.deleteBook(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

	
	
	
	
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> exceptionInvalidInputException(NullPointerException exception) {
		LOGGER.info("NullPointerException has occured");
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> exceptionInvalidInputException(MethodArgumentTypeMismatchException exception) {
		LOGGER.info("TypeMismatchException has occured");
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

}
