package com.book.service;

import java.util.List;

import com.book.dao.BookDAO;
import com.book.domain.Book;
import com.book.util.Page;

public class BookService {
	private BookDAO bookDAO = new BookDAO();
	public void add(Book book) {
		bookDAO.add(book);
	}
	public List<Book> getAll(String name, Page page) {
		return bookDAO.getAll(name,page);
	}
	public Book getById(int bid) {
		// TODO Auto-generated method stub
		return bookDAO.getById(bid);
	}
	public void del(int bid) {
		bookDAO.del(bid);
	}
	public void update(Book book) {
		bookDAO.update(book);
	}
	public Book getByName(String bname) {
		// TODO Auto-generated method stub
		return bookDAO.getByName(bname);
	}
	public int getCount(String name) {
		// TODO Auto-generated method stub
		return bookDAO.getCount(name);
	}

}
