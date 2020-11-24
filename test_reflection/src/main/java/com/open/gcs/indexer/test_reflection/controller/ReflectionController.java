/**
 * 
 */
package com.open.gcs.indexer.test_reflection.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ehurtado
 *
 */
public class ReflectionController {


  /**
   * @param obj
   */
  public static void getFiels(Object obj) {
    Field[] fields = obj.getClass().getDeclaredFields();

    List<String> listFields = toList(fields);

    listFields.forEach(field -> {
      System.out.println(field);
    });
  }


  /**
   * @param fields
   * @return
   */
  private static List<String> toList(Field[] fields) {
    List<String> fieldNames = new ArrayList<String>();
    for (Field field : fields)
      fieldNames.add(field.getName());
    return fieldNames;
  } 

}

