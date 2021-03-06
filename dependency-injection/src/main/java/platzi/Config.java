package platzi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {

  @Bean
  public MessageService beanMessageService() {
    return new HappyMessage();
  }
}
