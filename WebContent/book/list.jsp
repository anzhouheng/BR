<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{text-align: center;}
</style>
</head>
<body>
	<h3 style="text-align: center;">库存列表</h3>
	
	<p style="text-align: center;">
		<input type="text" id="name" style="width: 300px;height: 30px;outline: none;" value="${bName}">
		<input type="button" style="width: 100px; height: 36px;color:#FFFFFF; background: #ABCDF0;border: none;outline: none;" value="查找" onclick="fenye(1)"/>
	
	</p>
	<table border="1" cellspacing="0" cellpadding="5" style="border:1px solid #ABCDF0;border-collapse:collapse;width:100%; color:#286DA7;">
		<tr>
			<th>编号</th>
			<th>书名</th>
			<th>作者</th>
			<th>折扣</th>
			<th>价格</th>
			<th>数量</th>
			<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${list}" var="b">
		<tr>
			<td>${b.bid}</td>
			<td>${b.bname}</td>
			<td>${b.actor}</td>
			<td>${b.agio}折</td>
			<td>${b.price}</td>
			<td>${b.num}</td>
			<td><a href="${pageContext.request.contextPath}/bookServlet?m=show&bid=${b.bid}">详情</a></td>
			<td><a href="javascript:del(${b.bid})">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				<span>${page.currentPage}</span>/<span>${page.pageCount}</span>
				<button onclick="fenye(1)">首页</button>
				<button onclick="fenye(${page.prevPage})">上一页</button>
				<button onclick="fenye(${page.nextPage})">下一页</button>
				<button onclick="fenye(${page.pageCount})">尾页</button>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function del(id){
		if(confirm('是否删除编号为'+id+'书籍？')){
			location.href="${pageContext.request.contextPath }/bookServlet?m=del&bid="+id;	
		}
	}
	function fenye(curPage){
		var name=document.getElementById("name").value;
		location.href="bookServlet?m=list&name="+name+"&curPage="+curPage;
	}	
</script>
</html>