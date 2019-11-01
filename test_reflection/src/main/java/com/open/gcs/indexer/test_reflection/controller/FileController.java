/**
 * 
 */
package com.open.gcs.indexer.test_reflection.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.open.gcs.indexer.test_reflection.main.Main;

/**
 * @author ehurtado
 *
 */
public class FileController {
  
  /**
   * @param rootDirectory
   * @return
   */
  public static List<String> getFiles(String rootDirectory) {    
    List<String> lstEmptyEntry = new ArrayList<String>();
    
    return getFiles(rootDirectory, lstEmptyEntry);    
  }

  /**
   * @param directory
   * @param lstPaths
   * @return
   */
  private static List<String> getFiles(String directory,  List<String> lstPaths) {    
    DirectoryStream<Path> lstFiles = null;
    
    try {
      lstFiles = Files.newDirectoryStream(Paths.get(directory, new String[0]),
          p -> p.toString().endsWith(""));
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    lstFiles.forEach(p -> {
      String path = p.toString();
      File file = new File(p.toString());
      if (file.isFile()) {
        lstPaths.add(path);
      } else {
        getFiles(path, lstPaths);        
      }
    });
    
    return lstPaths;
  }
  
  /**
   * @param pathname
   * @return
   */
  public static Properties getProperties(String pathname) {
    String urlProperties = Main.class.getResource(pathname).getPath();

    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream(urlProperties));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return properties;
  }

}
