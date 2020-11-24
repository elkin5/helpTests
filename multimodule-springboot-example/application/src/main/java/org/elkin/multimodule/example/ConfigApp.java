/**
 * 
 */
package org.elkin.multimodule.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author ehurtado
 *
 */
@Configuration
//@PropertySources({@PropertySource("classpath:properties/db.properties")})
//@ComponentScan("org.elkin.multimodule")
@SpringBootApplication(scanBasePackages = "org.elkin.multimodule")
public class ConfigApp {

}
