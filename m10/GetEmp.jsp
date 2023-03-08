<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料</title>
</head>
<body style="background-color:#fdf5e6 ">
<div align="center">
<jsp:useBean id="emp" scope="request" class="com.lcpan.bean.EmpBean"/>
<table>
<tr><td>員工編號<td><input type="text" disabled value="<%=emp.getEmpno() %>">
	<tr><td>姓名<input type="text" disabled value="<%=emp.getEname() %>">
	<tr><td>到職日<input type="text" disabled value="<%=emp.getHiredate() %>">
	<tr><td>薪水<input type="text" disabled value="<%=emp.getSalary() %>">
	<tr><td>部門編號<input type="text" disabled value="<%=emp.getDeptno() %>">
	<tr><td>職稱<input type="text" disabled value="<%=emp.getTitle() %>">	
</table>
</div>
</body>
</html>