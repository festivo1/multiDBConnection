import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.utsi.springwebapp.config.MvcConfiguration;

public class App {

	public static void main(String[] args) {
		 AbstractApplicationContext context = new AnnotationConfigApplicationContext(MvcConfiguration.class);

	}

}
