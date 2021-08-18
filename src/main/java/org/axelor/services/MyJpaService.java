package org.axelor.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.axelor.db.Student;

import com.google.inject.*;
import com.google.inject.persist.Transactional;

@Singleton
@WebServlet(name="MyJpaService")
public class MyJpaService extends HttpServlet {
	
	 private static final long serialVersionUID = 1861227452784320290L;
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String name = request.getParameter("name");
	       Date dob = null;
			try {
				dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
				 System.out.println(dob);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
	       String phone = request.getParameter("phone");
	       String address = request.getParameter("address");
	       
	       
	      
	       createStudent(name,dob,phone,address);
	       
	       request.setAttribute("sname", name);
	       request.setAttribute("sdob", dob);
	       request.setAttribute("sphone", phone);
	       request.setAttribute("saddress", address);
	       request.getRequestDispatcher("student.jsp").forward(request, response);
	      
	 }
		
	 	@Inject Provider<EntityManager> em;

	 	@Transactional
		 public void createStudent(String name, Date dob, String phone, String address) {
	 		
			  Student s1 = new Student(name,dob,phone,address);
			  em.get().persist(s1);
		 }
}

