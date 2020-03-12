/**
 * 
 */
package org.elkin.multimodule.example;

import org.springframework.stereotype.Service;

/**
 * @author ehurtado
 *
 *
 *         Las librerias deben tener acceso por servicios
 */
@Service
public class LibraryService {
  public String isEvenOrOdd(Integer number) {
    return number % 2 == 0 ? "Even" : "Odd";
  }
}
