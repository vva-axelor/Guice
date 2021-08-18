package org.axelor.services;

import org.axelor.db.Student;
import javax.servlet.Filter;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class MyJpaModule extends ServletModule {
	
	 protected void configureServlets() {
		 
		   serve("/student").with(MyJpaService.class);
		   install(new JpaPersistModule("Guice-JPA"));  
		   filter("/*").through(PersistFilter.class);
		   
		  }
}
