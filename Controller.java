package ServletApplication;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/cal")
public class Controller extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		  
		   String value=req.getParameter("s1");
		   
		    if(value.equalsIgnoreCase("prime")) {
		    	 RequestDispatcher dispatcher= req.getRequestDispatcher("/pr");
		    	 dispatcher.forward(req, res);
		    }
		    else if(value.equalsIgnoreCase("factor")) {
		    
		    		 RequestDispatcher dispatcher=req.getRequestDispatcher("/fac");
		    		 dispatcher.forward(req, res);
		    	 }
		    		 
		    
		    else if(value.equalsIgnoreCase("factorial")) {
		    	
		    		RequestDispatcher dispatcher=req.getRequestDispatcher("/fact");
		    		dispatcher.forward(req,res);
		    	}
		    	 
		    
		    else if(value.equalsIgnoreCase("square")) {
		 
		    		RequestDispatcher dispatcher=req.getRequestDispatcher("/squ");
		    		dispatcher.forward(req, res);
		    	}
		    	 
		    }

	}


