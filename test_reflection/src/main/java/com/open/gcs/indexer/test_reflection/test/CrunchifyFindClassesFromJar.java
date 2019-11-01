/**
 * 
 */
package com.open.gcs.indexer.test_reflection.test;

import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * @author ehurtado
 *
 */
public class CrunchifyFindClassesFromJar {

  public static JSONObject getCrunchifyClassNamesFromJar(String crunchifyJarName) {
    JSONArray listofClasses = new JSONArray();
    JSONObject crunchifyObject = new JSONObject();
    try {
        JarInputStream crunchifyJarFile = new JarInputStream(new FileInputStream(crunchifyJarName));
        JarEntry crunchifyJar;

        while (true) {
            crunchifyJar = crunchifyJarFile.getNextJarEntry();
            if (crunchifyJar == null) {
                break;
            }
            if ((crunchifyJar.getName().endsWith(".class"))) {
                String className = crunchifyJar.getName().replaceAll("/", "\\.");
                String myClass = className.substring(0, className.lastIndexOf('.'));
                listofClasses.put(myClass);
            }
        }
        crunchifyObject.put("Jar File Name", crunchifyJarName);
        crunchifyObject.put("List of Class", listofClasses);
    } catch (Exception e) {
        System.out.println("Oops.. Encounter an issue while parsing jar" + e.toString());
    }
    return crunchifyObject;
}

public static void main(String[] args) {

    JSONObject myList = getCrunchifyClassNamesFromJar("/Users/<username>/Documents/javax.servlet.jsp.jar");
    System.out.println(myList);
}
}
