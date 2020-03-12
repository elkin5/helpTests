/**
 * 
 */
package org.elkin.multimodule.example.app;

import org.elkin.multimodule.example.AppController;
import org.elkin.multimodule.example.ConfigApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ehurtado
 *
 */
@SpringBootApplication(scanBasePackages = "org.elkin.multimodule")
public class AppExample implements CommandLineRunner {
  
  private AppController appController;

  public AppExample(AppController appController) {
    super();
    this.appController = appController;
  }

  public static void main(String[] args) {
//    SpringApplication.run(AppExample.class, args);
    
//    @SuppressWarnings("resource")
//    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
//    AppController appc = context.getBean(AppController.class);

    new SpringApplicationBuilder(AppExample.class).headless(false).run(args);
    System.out.println("End");
    System.exit(0);
  }

  /* (non-Javadoc)
   * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
   */
  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub
    System.out.println(appController.hello());
  }
}

