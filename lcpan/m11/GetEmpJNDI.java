package com.lcpan.m11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;


@WebServlet("/GetEmpJNDI")
public class GetEmpJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		 	 String empno=request.getParameter("empno");
			 String SQL="SELECT [empno]"
			 		+ " ,[ename]"
			 		+ ",[hiredate]"
			 		+ ",[salary]"
			 		+ ",[deptno]"
			 		+ " ,[title]"
			 		+ " FROM [jdbc].[dbo].[employee] WHERE empno=?";
				Connection conn = null;
			try {
				Context context = new InitialContext();
				DataSource ds=(DataSource)context.lookup("java:/comp/env/jdbc/servdb");
				 conn = ds.getConnection();
				
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
	
