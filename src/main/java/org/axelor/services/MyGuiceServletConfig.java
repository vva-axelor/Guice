package org.axelor.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class MyGuiceServletConfig  extends GuiceServletContextListener{
	@Override
	 protected Injector getInjector() {
		    return Guice.createInjector(new MyServletModule());
		  }
}
