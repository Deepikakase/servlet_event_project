package eventapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet(urlPatterns = "/all")

public class FetchAllEventsServlet extends HttpServlet {
	public void service(ServletRequest req,ServletResponse res)  throws ServletException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system","root","root");
			PreparedStatement ps=con.prepareStatement("select * from event");
			ResultSet rs=ps.executeQuery();
			req.setAttribute("rs",rs);
			RequestDispatcher rd=req.getRequestDispatcher("allevents.jsp");
			rd.include(req, res);
			rs.close();
			ps.close();
			con.close();
		
			
			
			
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

}
