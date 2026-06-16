package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HttpServlet
 */
public class HttpServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see jakarta.servlet.http.HttpServlet#jakarta.servlet.http.HttpServlet()
     */
    public HttpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String cid = request.getParameter("id");
		String cname = request.getParameter("name");
		String cloc = request.getParameter("loc");
		response.setContentType("text/html");
		out.print(cid+" "+cname+" "+cloc);
		out.print("<br></br>");
		out.print("<a href='customer.html'>Go Back</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();
		String cid = request.getParameter("id");
		String cname = request.getParameter("name");
		String cloc = request.getParameter("loc");
		out.print(cid+" "+cname+" "+cloc);
		response.setContentType("text/html");
		out.print("<br></br>");
		out.print("<a href='customer.html'>Go Back</a>");
	}

}
