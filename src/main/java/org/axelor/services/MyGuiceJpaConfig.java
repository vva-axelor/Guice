package org.axelor.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;

public class MyGuiceJpaConfig extends GuiceServletContextListener{
	@Override
	 protected Injector getInjector() {
		return Guice.createInjector(new MyJpaModule());
	}
}
