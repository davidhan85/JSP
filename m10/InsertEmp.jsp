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
<h2>新增成功</h2>
<%String cs=(String)request.getAttribute("errorMessage"); %>
錯誤訊息<textarea>
<%=cs %>
</textarea>
<table>
<tr><td>員工編號<td><input type="text" disabled value="<%=emp.getEmpno() %>" /></td></tr>
	<tr><td>姓名<input type="text" disabled value="<%=emp.getEname() %>" /></td></tr>
	<tr><td>到職日<input type="text" disabled value="<%=emp.getHiredate() %>" /></td></tr>
	<tr><td>薪水<input type="text" disabled value="<%=emp.getSalary() %>" /></td></tr>
	<tr><td>部門編號<input type="text" disabled value="<%=emp.getDeptno() %>" /></td></tr>
	<tr><td>職稱<input type="text" disabled value="<%=emp.getTitle() %>" />	</td></tr>
</table>
</div>
</body>
</html>