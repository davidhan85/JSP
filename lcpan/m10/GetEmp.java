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


@WebServlet("/GetEmp")
public class GetEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		 	 String empno=request.getParameter("empno");
			 String url="jdbc:sqlserver://localhost:1433;databaseName=jdbc;encrypt=false";
			 String user="banana";
			 String pwd="12345";
			 String SQL="SELECT [empno]"
			 		+ "      ,[ename]"
			 		+ "      ,[hiredate]"
			 		+ "      ,[salary]"
			 		+ "      ,[deptno]"
			 		+ "      ,[title]"
			 		+ "  FROM [jdbc].[dbo].[employee] WHERE empno=?";
			try {
				Class.forName(JDBC_DRIVER);
				Connection conn = DriverManager.getConnection(url,user,pwd);
				PreparedStatement stmt = conn.prepareStatement(SQL);
				stmt.setString(1, empno);
				ResultSet rs = stmt.executeQuery();
				EmpBean emp = new EmpBean();
				if(rs.next()) {
					emp.setEmpno(rs.getString("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setHiredate(rs.getString("hiredate"));
					emp.setSalary(rs.getString("salary"));
					emp.setDeptno(rs.getString("deptno"));
					emp.setTitle(rs.getString("title"));					
				}
				request.setAttribute("emp", emp);
				stmt.close();
				request.getRequestDispatcher("/m10/GetEmp.jsp").forward(request, response);
				
	
			}catch (Exception e) {
				// TODO: handle exception
			}
			
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

	}
	
