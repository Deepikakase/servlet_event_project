package eventapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/create")
public class CreateEventServlet extends HttpServlet {
	public void service(ServletRequest req,ServletResponse res)throws ServletException{
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		String title=req.getParameter("title");
		System.out.println(title);
		String loc=req.getParameter("loc");
		System.out.println(loc);
		String date=req.getParameter("date");
		System.out.println(date);
		String guest=req.getParameter("guest");
		System.out.println(guest);
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system","root","root");
			PreparedStatement ps=con.prepareStatement("insert into event values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, title);
			ps.setString(3, date);
			ps.setString(4, loc);
			ps.setString(5, guest);
			int row=ps.executeUpdate();
			System.out.println(row+":is created");
			
			
			PrintWriter pw=res.getWriter();
			pw.write("<html><body><h1> Event is Created </h1></body></html>");
			
			
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
			
			
			ps.close();
			con.close();
			
			
			
				
			
			
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
