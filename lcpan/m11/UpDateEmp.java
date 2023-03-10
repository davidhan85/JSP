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


@WebServlet("/UpDateEmp")
public class UpDateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		 	 String empno=request.getParameter("empno");
		 	 String ename = request.getParameter("ename");
		 	 String hiredate = request.getParameter("hiredate");
		 	 String salary = request.getParameter("salary");
		 	 String deptno = request.getParameter("deptno");
		 	 String title = request.getParameter("title");
			 String SQL="UPDATE [jdbc].[dbo].[employee]"
			 		+ " SET [ename] =?,[hiredate] =?,[salary] =?,[deptno] =?,[title]=?"
			 		+ " WHERE [empno]=?";
				Connection conn = null;
			try {
				Context context = new InitialContext();
				DataSource ds=(DataSource)context.lookup("java:/comp/env/jdbc/servdb");
				 conn = ds.getConnection();
			//	System.out.println("進入");
			//	System.out.println(empno);
			//	System.out.println(ename);
			//	System.out.println(hiredate);
			//	System.out.println(salary);
			//	System.out.println(deptno);
			//	System.out.println(title);
				PreparedStatement stmt = conn.prepareStatement(SQL);
				//stmt.setString(1, empno);
				stmt.setString(1, ename);
				stmt.setString(2, hiredate);
				stmt.setString(3, salary);
				stmt.setString(4, deptno);
				stmt.setString(5, title);
				stmt.setString(6, empno);
				int updataconunt = stmt.executeUpdate();
			//	System.out.println(updataconunt);
				if(updataconunt>0) {
					EmpBean emp = new EmpBean();
					    emp.setEmpno(empno);
			            emp.setEname(ename);
			            emp.setHiredate(hiredate);
			            emp.setSalary(salary);
			            emp.setDeptno(deptno);
			            emp.setTitle(title);				
					request.setAttribute("emp", emp);
				}
				stmt.close();
				request.getRequestDispatcher("/m10/UpDatetEmp.jsp").forward(request, response);
				
	
			}catch (Exception e) {
				// TODO: handle exception
			}
			
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

	}
	
