package platzi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

  //llamado de manera normal
  //private MessageService message = new SadMessage();
  
  //inyeccion de dependencia con getters y setters
  //private MessageService message;
  
  //Inyeccion dependencia spring
  final private MessageService service;

  @Autowired
  public MessagePrinter(MessageService service) {
      this.service = service;
  }

  public void printMessage() {
      System.out.println(this.service.getMessage());
  }
  
//  public void print() {
//    System.out.println(message.getMessage());
//  }

  //inyeccion de dependencia con getters y setters
//  public MessageService getMessage() {
//    return message;
//  }

  //inyeccion de dependencia con getters y setters
//  public void setMessage(MessageService message) {
//    this.message = message;
//  }
  
}
