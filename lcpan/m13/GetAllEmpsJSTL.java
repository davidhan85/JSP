package com.lcpan.m13;

import java.beans.Expression;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcpan.bean.EmpBean;


@WebServlet("/GetAllEmpsJSTL")
public class GetAllEmpsJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; ;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		 	
			 String url="jdbc:sqlserver://localhost:1433;databaseName=jdbc;encrypt=false";
			 String user="banana";
			 String pwd="1234";
			 String SQL="SELECT * from dbo.employee";
			try {
				Class.forName(JDBC_DRIVER);
				Connection conn = DriverManager.getConnection(url,user,pwd);
				PreparedStatement stmt = conn.prepareStatement(SQL);				
				ResultSet rs = stmt.executeQuery();
				List<EmpBean> emps = new ArrayList<>();
				EmpBean emp = null;
				while(rs.next()) {
					emp=new EmpBean();
					emp.setEmpno(rs.getString("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setHiredate(rs.getString("hiredate"));
					emp.setSalary(rs.getString("salary"));
					emp.setDeptno(rs.getString("deptno"));
					emp.setTitle(rs.getString("title"));
					emps.add(emp);
				}
				request.setAttribute("emps", emps);
				stmt.close();
				request.getRequestDispatcher("/m10/GetAllEmps.jsp").forward(request, response);
				conn.close();
	
			}catch (Exception e) {
				// TODO: handle exception
			}
			
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

	}
	
