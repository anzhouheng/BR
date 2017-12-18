package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.domain.Book;
import com.book.service.BookService;

/**
 * Servlet implementation class BookRegisterServlet
 */
@WebServlet("/bookRegisterServlet")
public class BookRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String m = request.getParameter("m");
		if(m.equals("add")){
			add(request,response);
		}
		if(m.equals("update")){
			update(request,response);
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		Book book = bookService.getById(bid);
		request.setAttribute("book", book);
		request.getRequestDispatcher("book/update.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		boolean flag = true;
		int bid = 0;
		try {
			bid =Integer.parseInt(request.getParameter("bid"));
		} catch (Exception e) {
			flag = false;
		}
		String[] errors=new String[6];
		String bname = request.getParameter("bname");
		Book book2 = bookService.getByName(bname);
		if(bname==null||bname.trim().equals("")){
			errors[0]="书名不能为空";
		}
		if(bid==0){
			if(book2!=null){
				errors[0]="该书已被注册不可重复注册";
			}
		}
		String cate = null;
		try {
			String[] cates = request.getParameterValues("cate");
			cate = "";
			for (String str : cates) {
				cate+=str+" ";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			errors[1]="请选择书籍分类";
		}
		String actor = request.getParameter("actor");
		if(actor==null||actor.trim().equals("")){
			errors[2]="请填写作者，（不详请填写‘不详’）";
		}
		int agio = 0;
		try {
			agio = Integer.parseInt(request.getParameter("agio"));
		} catch (Exception e) {
			errors[3]="注意选择折扣";
		}
		double price=0;
		try {
			price =Double.parseDouble(request.getParameter("price"));
		} catch (Exception e) {
			errors[4]="请输入正确的价格（小数点后最多两位）";
		}
		int num=0;
		try {
			num =Integer.parseInt(request.getParameter("num"));
		} catch (Exception e) {
			errors[5]="请输入正确的数字（不可以是小数）";
		}
		String description = request.getParameter("description");
		
		boolean b=true;
		for (String error : errors) {
			if(error!=null){
				b=false;
			}
		}
		
		if(b){
			Book book = null;
			if(flag){
				book = new Book(bid, bname, cate, actor, agio, price, num, description);
				bookService.update(book);
			}else {
				book = new Book(bname, cate, actor, agio, price, num, description);
				bookService.add(book);
				book=bookService.getByName(book.getBname());
			}
			request.setAttribute("book", book);
			request.getRequestDispatcher("book/success.jsp").forward(request, response);
		}else {
			Book book = new Book(bname, cate, actor, agio, price, num, description);
			request.setAttribute("errors", errors);
			request.setAttribute("book", book);
			request.getRequestDispatcher("book/register.jsp").forward(request, response);
		}
	}

}
