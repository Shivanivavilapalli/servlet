package db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class ServletDb
 */
public class ServletDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("id"));
		String pname = request.getParameter("name");
		double pprice = Double.parseDouble(request.getParameter("price"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			PreparedStatement pmst = con.prepareStatement("insert into product value(?,?,?)");
			pmst.setInt(1, pid);
			pmst.setString(2, pname);
			pmst.setDouble(3, pprice);
			pmst.executeUpdate();
			response.setContentType("text/html");
			out.println("Row Created");
			out.print("<br></br>");
			pmst.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		out.print("<a href='index.html'>go back</a>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
