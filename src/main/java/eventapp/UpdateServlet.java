package eventapp

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
import javax.servlet.http.HttpServlet;

public class UpdateServlet  extends HttpServlet{
		public void service(ServletRequest req,ServletResponse res)throws ServletException{
			int id=Integer.parseInt(req.getParameter("id"));
			String title=req.getParameter("title");
			String loc=req.getParameter("loc");
			String date=req.getParameter("date");
			String guest=req.getParameter("guest");
			
			
			
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
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

}
