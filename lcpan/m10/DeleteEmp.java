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


@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
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
			 String pwd="12345";
			 String SQL="DELETE FROM [jdbc].[dbo].[employee]"
			 		+"WHERE empno=?"; 
			try {
				Class.forName(JDBC_DRIVER);	
				Connection conn = DriverManager.getConnection(url,user,pwd);
				PreparedStatement stmt = conn.prepareStatement(SQL);			
				stmt.setString(1, empno);
				 stmt.executeUpdate();				           
			            request.getRequestDispatcher("/m10/DeleteEmp.jsp").forward(request, response);
			            stmt.close();
			            conn.close();
				   }catch (Exception e) {
				e.printStackTrace();
			}			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

	}
	
