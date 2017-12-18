<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="public/css/public.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<div class="layout" style="width: 900px;">
		<%@include file="public/header.jsp"%>
		<%@include file="public/left.jsp"%>
		<iframe name="main" src="book/main_index.jsp" style="border:1px solid #FFFFFF;width:618px;height:458px;float:right;padding: 20px 20px;"></iframe>
	</div>
</body>
</html>