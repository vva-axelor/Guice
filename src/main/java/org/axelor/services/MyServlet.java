package org.axelor.services;


import com.google.inject.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


@Singleton
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1861227452784320290L;

	   @Inject
	   private MyService myService;

	   protected void service(HttpServletRequest request, HttpServletResponse response) 
			   throws ServletException, IOException {
		   
	          response.getWriter().println("Service: " + myService.doStuff());
	   }
}


@ImplementedBy(MyServiceImpl.class)
interface MyService {
   String doStuff();
}

class MyServiceImpl implements MyService {
	   @Override
	   public String doStuff() {
	          return "doing stuff!";
	   }
}