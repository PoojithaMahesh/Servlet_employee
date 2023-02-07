package servlet_employee_controllor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_employee_dao.EmployeeDao;
import servlet_employee_dto.Employee;

public class EmployeControllor extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

   int id=Integer.parseInt(req.getParameter("id"));
   String name=req.getParameter("name");
   String address=req.getParameter("address");
   String email=req.getParameter("email");
   String password=req.getParameter("password");
   long phone=Long.parseLong(req.getParameter("phone"));
   Employee employee=new Employee();
   employee.setAddress(address);
   employee.setEmail(email);
   employee.setId(id);
   employee.setName(name);
   employee.setPassword(password);
   employee.setPhone(phone);
   EmployeeDao dao=new EmployeeDao();
//   dao.saveEmployee(employee);
   dao.updateEmployee(id, employee);
   PrintWriter printWriter=resp.getWriter();
   printWriter.print("updated successfully");
}
}
