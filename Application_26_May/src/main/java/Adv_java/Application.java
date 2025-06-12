package Adv_java;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/dis")
public class Application extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name= req.getParameter("name");
		req.setAttribute("Name",name);
		String pwd=req.getParameter("pass");
		
		System.out.println("password : "+pwd);
		if(!pwd.isBlank())
		{
			RequestDispatcher rd= req.getRequestDispatcher("Welcome.jsp");
			rd.forward(req,  res);
		}
		else
		{
			RequestDispatcher rd= req.getRequestDispatcher("error.jsp");
			rd.forward(req, res);
		}
		
	}

}
