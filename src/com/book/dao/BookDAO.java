package com.book.dao;

import java.util.List;

import com.book.domain.Book;
import com.book.util.JdbcUtil;
import com.book.util.Page;

public class BookDAO {

	public void add(Book book) {
		String sql ="insert into book(bname,cate,actor,agio,price,num,description) values(?,?,?,?,?,?,?)";
		JdbcUtil.execute(sql , book.getBname(),book.getCate(),book.getActor(),book.getAgio(),book.getPrice(),book.getNum(),book.getDescription());
	}

	public List<Book> getAll(String name, Page page) {
		List<Book> list = JdbcUtil.getList(Book.class, "select * from book where bname like ? limit ?,?","%"+name+"%",page.getStartRecord(),page.getPageSize());
		return list;
	}

	public Book getById(int bid) {
		// TODO Auto-generated method stub
		return (Book) JdbcUtil.getObjectById(Book.class, "select * from book where bid=?", bid);
	}

	public void del(int bid) {
		JdbcUtil.execute("DELETE FROM book WHERE bid=?", bid);
	}

	public void update(Book book) {
		String sql = "UPDATE book SET bname=?,cate=?,actor=?,agio=?,price=?,num=?,description=? WHERE bid=?";
		JdbcUtil.execute(sql , book.getBname(),book.getCate(),book.getActor(),book.getAgio(),book.getPrice(),book.getNum(),book.getDescription(),book.getBid());
	}

	public Book getByName(String bname) {
		// TODO Auto-generated method stub
		return (Book) JdbcUtil.getObjectById(Book.class, "select * from book where bname=?",bname);
	}

	public int getCount(String name) {
		return JdbcUtil.getCount("select count(*) from book where bname like ?","%"+name+"%");
	}
	

}
