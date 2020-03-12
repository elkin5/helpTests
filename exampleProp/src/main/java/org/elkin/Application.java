/**
 * 
 */
package org.elkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(Application.class);
  private HelloController helloController;

  public Application(HelloController helloController) {
    this.helloController = helloController;
  }
  
  public static void main(String[] args) {
    new SpringApplicationBuilder(Application.class).headless(false).run(args);
    System.out.println("End");
    System.exit(0);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
   */
  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub
   System.out.println("hola");
   System.out.println(helloController.hello());
  }
}

