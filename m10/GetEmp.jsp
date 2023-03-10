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
<form method="post" action="UpDateEmp"><%--從JSP把值傳給Servlet的話需使用form的action設定路徑 --%>
<table>
<%--從查詢轉到更新時需要有name UPDATE才能抓到從查詢的JSP送來的值 --%>
<tr><td>員工編號<td><input type="text" name="empno" readonly="readonly" value="<%=emp.getEmpno() %>">
	<tr><td>姓名<input type="text" name="ename" value="<%=emp.getEname() %>">
	<tr><td>到職日<input type="text" name="hiredate" value="<%=emp.getHiredate() %>">
	<tr><td>薪水<input type="text" name="salary" value="<%=emp.getSalary() %>">
	<tr><td>部門編號<input type="text" name="deptno" value="<%=emp.getDeptno() %>">
	<tr><td>職稱<input type="text" name="title" value="<%=emp.getTitle() %>">	
	
</table>
<input type="submit" value="新增" />
</form>
</div>
</body>
</html>