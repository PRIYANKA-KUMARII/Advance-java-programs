package ServletApplication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/fact")
public class Factorial extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("s"));
		for(int i=num; i>0; i--)
		{
			int fact = i;
		}
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		
		}
	}


