/**
 * 
 */
package org.elkin.multimodule.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ehurtado
 *
 */
@Controller
public class AppController {
  private LibraryService libraryService;
  private HelloController helloController;
//  @Value("${person.name}")
//  private String name;

  // constructor
  public AppController(LibraryService libraryService, HelloController helloController) {
    super();
    this.libraryService = libraryService;
    this.helloController = helloController;
  }

//  @GetMapping("/validate")
  public String isEvenOrOdd(@RequestParam("number") Integer number) {
    return libraryService.isEvenOrOdd(number);
  }

//  @GetMapping("/greet")
  public String hello() {
    return helloController.hello();
  }
}
