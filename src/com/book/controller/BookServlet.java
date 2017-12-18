package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.domain.Book;
import com.book.service.BookService;
import com.book.util.Page;


/**
 * Servlet implementation class BookRegisterServlet
 */
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService = new BookService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m==null||m.trim().equals("")){
			index(request,response);
		}
		if(m.equals("list")){
			list(request,response);
		}
		if(m.equals("show")){
			getById(request,response);
		}
		if(m.equals("del")){
			del(request,response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath()+"/index.vm");
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bid =Integer.parseInt(request.getParameter("bid"));
		bookService.del(bid);
		response.sendRedirect(request.getContextPath()+"/bookServlet?m=list");
	}

	private void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid =Integer.parseInt(request.getParameter("bid"));
		Book book=bookService.getById(bid);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/book/show.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		name=name==null||name.trim().equals("")?"":name.trim();
		int count=bookService.getCount(name);
		String curPage = request.getParameter("curPage");
		Page page = new Page(curPage, count, 4);
		List<Book> list =bookService.getAll(name,page);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("bName", name);
		request.getRequestDispatcher("/book/list.jsp").forward(request, response);
	}


}
