package eventapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DeleteServlet  extends HttpServlet{
	public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system", "root", "root");
			PreparedStatement ps=con.prepareStatement("delete from event where id=?");
			ps.setInt(1, id);
			int row=ps.executeUpdate();
			System.out.println(row+" : is Deleted");
			
			PrintWriter pw=res.getWriter();
			pw.write("<h1>Employee Deleted Successfully`</h1>");
			
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
		
	

}
