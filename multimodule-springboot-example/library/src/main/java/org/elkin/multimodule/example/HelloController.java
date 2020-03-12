/**
 * 
 */
package org.elkin.multimodule.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @author ehurtado
 *
 */
@Controller
public class HelloController {

  @Value("${person.name}")
  private String name;

  private String name2;

  public String hello() {
    return "Hello, " + name + "!";
  }

  public String getName2() {
    return name2;
  }

  public void setName2(String name2) {
    this.name2 = name2;
  }
}
