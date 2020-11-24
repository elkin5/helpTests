/**
 * 
 */
package com.open.gcs.indexer.test_reflection.controller;

import java.util.List;
import java.util.Properties;

/**
 * @author ehurtado
 *
 */
public class FrontController {
  
  public FrontController(){
    
  }

  public void analyzeFiles() {
    Properties configProperties = FileController.getProperties("/config/config.properties");
    String rootDirectory = configProperties.getProperty("source.path2");
    List<String> lstFiles = FileController.getFiles(rootDirectory);
    
//    lstFiles.forEach(p -> System.out.println(p));
    String value = lstFiles.get(0);
    
    System.out.println(value);
    try {
      Class userClass = Class.forName("com.test.model.AdminUser");  
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
 
}
