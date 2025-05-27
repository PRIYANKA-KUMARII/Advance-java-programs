package ServletApplication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/pr")
public class Prime  extends GenericServlet{

	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
          int num=Integer.parseInt(req.getParameter("v1"));
          boolean b=true;
          int i;
          int count=0;
          for( i=2; i<num/2; i++);
          {
        	  if(num%i==0)
        	  {
        		  count++;
        	  }
          }
          if(count>0)
          {
        	  b=false;
          }
          else {
        	  b=true;
          }
         PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
				if(b) 
			pw.println("This is prime num.");
		else 
				pw.println("Not prime.");
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		
		
		//logic
		
		
		
		
		
		
		
		
		
		
	}

}
