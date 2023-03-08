package com.lcpan.m10;

import java.beans.Expression;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcpan.bean.EmpBean;


@WebServlet("/InsertEmp")
public class InsertEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		 	 String empno=request.getParameter("empno");
		 	 String ename = request.getParameter("ename");
		 	 String hiredate = request.getParameter("hiredate");
		 	String salary = request.getParameter("salary");
		 	String deptno = request.getParameter("deptno");
		 	String title = request.getParameter("title");
		 	
		 	 String url="jdbc:sqlserver://localhost:1433;databaseName=jdbc;encrypt=false";
			 String user="banana";
			 String pwd="1234";
			 String SQL="INSERT INTO [jdbc].[dbo].[employee]"
			 		+"VALUES(?,?,?,?,?,?)"; 
			try {
				Class.forName(JDBC_DRIVER);	
				Connection conn = DriverManager.getConnection(url,user,pwd);
				PreparedStatement stmt = conn.prepareStatement(SQL);
				//ResultSet rs = stmt.executeQuery();
				//EmpBean emp = new EmpBean();				
				stmt.setString(1, empno);
				stmt.setString(2, ename);
				stmt.setString(3, hiredate);
				stmt.setString(4, salary);
				stmt.setString(5, deptno);
				stmt.setString(6, title);
				   int rows = stmt.executeUpdate();				   
				   if(rows>0) {
					   EmpBean emp = new EmpBean();	
			            emp.setEmpno(empno);
			            emp.setEname(ename);
			            emp.setHiredate(hiredate);
			            emp.setSalary(salary);
			            emp.setDeptno(deptno);
			            emp.setTitle(title);
			            request.setAttribute("emp", emp);
			            request.getRequestDispatcher("/m10/InsertEmp.jsp").forward(request, response);
				   }else {
					   request.setAttribute("errorMessage", "新增員工失敗！");
			            request.getRequestDispatcher("/m10/InsertEmp.jsp").forward(request, response);
				   }
		
				//request.setAttribute("emp", emp);				
				stmt.close();
				conn.close();
				//request.getRequestDispatcher("/m10/InsertEmp.jsp").forward(request, response);				
			}catch (Exception e) {
				request.setAttribute("errorMessage", "資料庫操作錯誤：" + e.getMessage());
		        request.getRequestDispatcher("/m10/InsertEmp.jsp").forward(request, response);
			}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

	}
	
