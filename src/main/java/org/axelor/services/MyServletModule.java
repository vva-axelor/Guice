package org.axelor.services;

import com.google.inject.servlet.ServletModule;

public class MyServletModule extends ServletModule{
	
	@Override
	protected void configureServlets() {
		
		serve("/*").with(MyServlet.class);
	}
}
