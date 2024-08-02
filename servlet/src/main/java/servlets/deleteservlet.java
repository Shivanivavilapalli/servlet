package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnections.employedb;
import services.employeservice;

@WebServlet("/delete")

public class deleteservlet extends HttpServlet {
	@Override
//	here doget is used to delete the data.
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		string only can write here so integer is type casting.
		int id = Integer.parseInt(req.getParameter("id"));
		employeservice service = new employeservice(employedb.getconnection());
		service.delbyid(id);
		boolean f = false;
		if (f) {
			resp.sendRedirect("welcome.jsp");

		} else {
			resp.sendRedirect("welcome.jsp");
		}
	}

}
