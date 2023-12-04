

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http. HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class Register extends  HttpServlet{
	



	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		String e=req.getParameter("email");
		String p=req.getParameter("password");
		
		System.out.println(name+" "+e+" "+p);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Added");

		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
		 System.out.println("Connection Sucesses");
		 
		 PreparedStatement pstm=con.prepareStatement("insert into webuser(name, email,password) values(?,?,?)");
		 pstm.setString(1,name);
		 pstm.setString(2, e);
	     pstm.setString(3, p);
	     
	     int i=pstm.executeUpdate();
	     PrintWriter pw=resp.getWriter();
	     
	     if(i!=0)
	     {
	    	 System.out.println("Record inserted");
	    	 //pw.write("Record Inserted");
	    	 resp.sendRedirect("LoginUser.html");
	      }
	     
	     else {
	    	 System.out.println("error");
	    	 //pw.write("error"");
	    	 resp.sendRedirect("Error.html");
	    
	     
	    
	     
	 }
	     
		}
	     catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

		// TODO Auto-generated method stub
		
	}
	


