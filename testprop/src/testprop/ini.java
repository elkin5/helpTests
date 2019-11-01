package testprop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ini {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    // TODO Auto-generated method stub

    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    System.out.println(rootPath);
    String appConfigPath = rootPath + "redis.properties";
    String catalogConfigPath = rootPath + "catalog";
     
    Properties appProps = new Properties();
    appProps.load(new FileInputStream(appConfigPath));
    
    String app = appProps.getProperty("redis.valve.password");
    System.out.println(app);
  }

}
