package guice;

import com.google.inject.*;
import com.google.inject.name.Names;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;
import com.google.inject.name.Named;


@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD })
@Retention(RUNTIME)
@interface NewMessage {}


public class GuiceTester {

	public static void main(String[] args) {
		Injector inject = Guice.createInjector(new GuiceDemoModule());
		
		GuiceDemo d = inject.getInstance(GuiceDemo.class);
		//d.printM();
		d.getWelcomeMessage();
	}
}

class GuiceDemo{
	private Welcome wlc;
	
	@Inject
	public GuiceDemo ( Welcome wlc){
		this.wlc = wlc;
	}
	/*
	@Inject
	public GuiceDemo (@NewMessage Welcome wlc){
		this.wlc = wlc;
	}
	
	
	@Inject
	public GuiceDemo (@Named("Hello") Welcome wlc){
		this.wlc = wlc;
	} 
	
	
	private String str;
	@Inject
	public GuiceDemo (@Named("Hello1") String str){
		this.str = str;
	} 
	
	public void printM() {
		System.out.println(str);
	}
	
	*/
	public void getWelcomeMessage(){
		wlc.welcomeMessage();
	}
}

class GuiceDemoModule extends AbstractModule{
	protected void configure() {
		/*
		
		//simple binding
		bind(Welcome.class).to(WelcomeImpl.class);
	
		//linked binding with multiple implementation
		bind(WelcomeImpl.class).to(NewWelcomeImpl.class);
		
	 	
		
		//binding annotation
		bind(Welcome.class).annotatedWith(NewMessage.class).to(NewWelcomeImpl.class);
		
		//Named binding
		bind(Welcome.class).annotatedWith(Names.named("Hello")).to(NewWelcomeImpl.class);
		
		
		//constant binding
		bind(String.class).annotatedWith(Names.named("Hello1")).toInstance("message to be printed");
		
		*/
		//@provides
		bind(Welcome.class).toProvider(MsgProvider.class);
		
	}
}


interface Welcome {
	public void welcomeMessage();
}

class WelcomeImpl implements Welcome{
	public WelcomeImpl() {}
	private String s1;
	private String s2;
	
	@Inject
	public WelcomeImpl(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void welcomeMessage () {
		System.out.println("Hello Welcome!!!");
		System.out.println("Name:"+s1);
		System.out.println("SurName:"+s2);
		
	}
	
}

/*

class NewWelcomeImpl extends WelcomeImpl{

	public void welcomeMessage () {
		System.out.println("Inside New Welcome!!!");
	}
}

*/

class MsgProvider implements Provider<Welcome>{
	public Welcome get() {
	      String s1 = "Vaishali";
	      String s2 = "Vaghela";

	      Welcome w = new WelcomeImpl(s1, s2);
	      return w;
	   }
}
		