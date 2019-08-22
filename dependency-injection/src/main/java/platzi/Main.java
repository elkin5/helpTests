package platzi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    //llamado normal
//    MessagePrinter printer = new MessagePrinter();
    
    //inyeccion de dependencia con getters y setters
//    printer.setMessage(new SadMessage());
//    printer.print();
    @SuppressWarnings("resource")
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    
    //Aqui le digo que se debe inyectar
    MessagePrinter printer = context.getBean(MessagePrinter.class);
    
    printer.printMessage();
  }

}
