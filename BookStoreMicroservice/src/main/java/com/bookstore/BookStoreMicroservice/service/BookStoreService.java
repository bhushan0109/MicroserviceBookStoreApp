package com.bookstore.BookStoreMicroservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.BookStoreMicroservice.dto.BookDTO;
import com.bookstore.BookStoreMicroservice.model.Book;
import com.bookstore.BookStoreMicroservice.repository.BookStoreRepository;

@Service
public class BookStoreService implements IBookStoreService {
	@Autowired
	public BookStoreRepository bookstoreRepository;

	@Override
	public List<Book> getAllBooks() {
		List<Book> booksList = bookstoreRepository.findAll();
		if (booksList.isEmpty()) {
			return null;
		}
		return booksList;
	}

	@Override
	public Book createBookData(BookDTO bookDTO) {
		Book bookData = null;
		bookData = new Book(bookDTO);
		return bookstoreRepository.save(bookData);
	}

	public Book getBookDataByBookId(UUID bookId) {

		return bookstoreRepository.findById(bookId).orElseThrow(() -> new RuntimeException("someArgument"));

	}

	@Override
	public void deleteBookDataByBookId(UUID bookId) {
		Book bookData = this.getBookDataByBookId(bookId);
		bookstoreRepository.delete(bookData);
	}
	@Override
	public Book updateBookDataByBookId(UUID bookId, BookDTO bookDTO) {
		Book bookData = this.getBookDataByBookId(bookId);
		bookData.updateBookDataByBookId(bookDTO);
		return bookstoreRepository.save(bookData);
	}

	public long count() {
		return bookstoreRepository.count();
	}


	@Override
	public Book getBooksByBookName(String bookName) {
		Book booksList = bookstoreRepository.findBooksByBookName(bookName);

		return booksList;
	}

	
}