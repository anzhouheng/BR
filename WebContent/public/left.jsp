<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{display: block;width: 240;height: 50px;text-align: center;color:#FFFFFF;}
</style>
</head>
<body>
	<div style="width:240px;height:450px; background-image: url('${pageContext.request.contextPath}/imgs/bg_left.png');padding-top:50px;float:left;">
		<div>
			<a href="book/main_index.jsp" target="main">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a>
			<a href="${pageContext.request.contextPath}/book/register.jsp" target="main">入库登记</a>
			<a href="${pageContext.request.contextPath}/bookServlet?m=list" target="main">库存列表</a>
		</div>
	</div>
</body>
</html>