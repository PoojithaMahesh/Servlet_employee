package servlet_employee_controllor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_employee_dao.EmployeeDao;
import servlet_employee_dto.Employee;



public class LoginControllor extends HttpServlet{
	   @Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   	   PrintWriter printWriter=resp.getWriter();
	   	   int id=Integer.parseInt(req.getParameter("id"));
	   	   String email=req.getParameter("email");
	   	   String password=req.getParameter("password");
	   	   
	   	Employee employe=new Employee();
	   	
	   	EmployeeDao dao=new EmployeeDao();
	   	Employee employee=dao.loginPerson(id);
	   	if(email.equals(employee.getEmail())&&password.equals(employee.getPassword())) {
//	   	 RequestDispatcher dispatcher=req.getRequestDispatcher("form4.html");
//	   	 dispatcher.forward(req, resp);
	   		resp.sendRedirect("https://www.google.com/");
	   	}
	   	else {
	   	 RequestDispatcher dispatcher=req.getRequestDispatcher("form3.html");
	   	 dispatcher.forward(req, resp);
	   	}
	   	
	   	
	   }
}
