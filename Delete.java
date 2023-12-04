import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

@WebServlet("/DeleteServlet")
public class Delete extends HttpServlet {
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String e=req.getParameter("email");
	System.out.println(e);
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded"); 
		
		DriverManager.getConnection("jdbc:mysql://localhost:3306/ bank", "root","root");
		System.out.println("Connection Success");
		
		PreparedStatement pstm=prepareStatement("delete from webuser? where email");
		pstm.setString(1, e);
		
		int i=pstm.executeUpdate();
		PrintWriter pw=resp.getWriter();
		if(i!=0)
		{
			System.out.println("Record delted");
			//pw.write("Record Delete
		
			resp.sendRedirect("RegisterUser.html");
		}
		else
		{
			System.out.println("error");
			resp.sendRedirect("Delete.html");
		}
	
		
		
		
		
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

}

	private PreparedStatement prepareStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

