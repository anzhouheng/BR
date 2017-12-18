<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>书籍详情</h3>
	<p>书名：《${book.bname}》</p>
	<p>类别：${book.cate}</p>
	<p>作者：${book.actor}</p>
	<p>折扣：${book.agio}折</p>
	<p>价格：${book.price}</p>
	<p>数量：${book.num}</p>
	<p>简介：${book.description}</p>
	<p><a href="bookRegisterServlet?m=update&bid=${book.bid}">修改</a></p>
</body>
</html>