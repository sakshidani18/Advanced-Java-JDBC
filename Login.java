

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String e=req.getParameter("email");
		String p=req.getParameter("pass");
		
		System.out.println(e+" "+p);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ bank",  "root","root");
			System.out.println("Connection Success");
			
			PreparedStatement pstm=con.prepareStatement("select * from webuser where email=?");
			pstm.setString(1,e);
			
			ResultSet rs=pstm.executeQuery();
			String name=null;
			String email= null;
			String pass=null;
			while(rs.next())
			{
			  name=rs.getString("name");
			  name=rs.getString("email");
			  name=rs.getString("pass");
			}
			
			if(e.equals(email)&&p.equals(pass))
			{
				System.out.println("Welcome User: +name");
				//pw.write ("Welcome User:"+name);
				resp.sendRedirect("Update.html");
			}
			
			else
			{
				System.out.println("Error");
				//pw.write ("error");
				resp.sendRedirect("LoginUser.html");
			}
			
				
			
			
			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
	}
	
}

	



