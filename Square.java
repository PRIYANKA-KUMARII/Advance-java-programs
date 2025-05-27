package ServletApplication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/squ")
public class Square  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num=Integer.parseInt(req.getParameter("s"));
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		
	}

}
