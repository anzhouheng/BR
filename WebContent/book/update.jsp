<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	span{color:#FF0000;font-size: 12px;}
</style>
</head>
<body>
<div style="margin:60px 0 0 80px;">

	<form action="${pageContext.request.contextPath}/bookRegisterServlet?m=add" method="post">
		<input type="hidden" name="bid" value="${book.bid}">
		<p>书名：<input type="text" name="bname" id="bname" value="${book.bname}"><span>${errors[0]}</span></p>
		<p>类别：<input type="checkbox" name="cate" value="科学">科学
		<input type="checkbox" name="cate" value="教育">教育
		<input type="checkbox" name="cate" value="文学">文学
		<input type="checkbox" name="cate" value="生活">生活
		<input type="checkbox" name="cate" value="其他">其他<span>${errors[1]}</span></p>
		<p>作者：<input type="text" name="actor" id="actor" value="${book.actor}"><span>${errors[2]}</span></p>
		<p>折扣：
		<c:if test="${book.agio==10}">
			<input type="radio" name="agio" value="10" checked="checked">全价
		</c:if>
		<c:if test="${book.agio!=10}">
			<input type="radio" name="agio" value="10">全价
		</c:if>
		<c:if test="${book.agio==9}">
		  	<input type="radio" name="agio" value="9" checked="checked">九折
		</c:if>
		<c:if test="${book.agio!=9}">
			<input type="radio" name="agio" value="9">九折
		</c:if>
		<c:if test="${book.agio==8}">
			<input type="radio" name="agio" value="8" checked="checked">八折
		</c:if>
		<c:if test="${book.agio!=8}">
			<input type="radio" name="agio" value="8">八折
		</c:if>
		<c:if test="${book.agio==7}">
			<input type="radio" name="agio" value="7" checked="checked">七折
		</c:if>
		<c:if test="${book.agio!=7}">
			<input type="radio" name="agio" value="7">七折
		</c:if>
		<c:if test="${book.agio==6}">
			<input type="radio" name="agio" value="6" checked="checked">六折
		</c:if>
		<c:if test="${book.agio!=6}">
			<input type="radio" name="agio" value="6">六折
		</c:if>
		<span>${errors[3]}</span>
		</p>
		<p>价格：<input type="text" name="price" id="price" value="${book.price}"><span>${errors[4]}</span></p>
		<p>数量：<input type="text" name="num" id="num" value="${book.num}"> <span>${errors[5]}</span></p>
		<p>简介 <textarea rows="5" cols="30" name="description" style="vertical-align: top;">${book.description}</textarea></p>
		<p><input type="submit" value="登记">
		<input type="reset" value="取消"></p>
	</form>
</div>
<script type="text/javascript">
	 
</script>
</body>
</html>