<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Using jsp bean</h1>
<jsp:useBean id="StringBean" class="com.lcpan.bean.StringBean"/>
<ol>
<li><jsp:setProperty name="StringBean" property="message" value="this is test"/>
Set and getProperty:<br>
<jsp:getProperty name="StringBean" property="message"/>
<li><%StringBean.setMessage("this is a x"); %>
Set and get:<br>
<i><%=StringBean.getMessage() %></i>

</ol>
</body>
</html>