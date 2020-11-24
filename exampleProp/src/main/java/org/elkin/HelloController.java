/**
 * 
 */
package org.elkin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @Value("${person.name}")
    private String name;

    
    public String hello(){
        return "Hello, " + name + "!";
    }
}