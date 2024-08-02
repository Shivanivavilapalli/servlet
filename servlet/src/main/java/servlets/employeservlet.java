package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnections.employedb;
import models.employe;
import services.employeservice;
@WebServlet("/toconnect")
//here / is used to like url's
//servlets is used to connect remaining layers
//extend keyword used to extend seervlet class.
public class employeservlet extends HttpServlet {
	@Override
//	request is used to html and servlet connect,resp is used to popup
//	dopost to get security.
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
//		it will only allow string values
		
	  String name = req.getParameter("name");
	String email = req.getParameter("email");
	 long phone =  Long.parseLong(req.getParameter("phoneno"))  ;
	employe e = new employe(0,name,email,phone);
	employeservice service=new employeservice (employedb.getconnection());
//	.addemploye for insertioning data
	boolean i = service.addemploye(e);
	if(i) {
//		if data is inserted then it should redirect to another page
		resp.sendRedirect("welcome.jsp");
	}
	else {
		resp.sendRedirect("register.jsp");
	}
	
	
	
	}

	
	

}
