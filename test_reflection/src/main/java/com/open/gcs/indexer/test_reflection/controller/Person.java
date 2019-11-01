/**
 * 
 */
package com.open.gcs.indexer.test_reflection.controller;

/**
 * @author ehurtado
 *
 */
public class Person {

  private String fullname;
  private int age;
  
  /**
   * print the person
   */
  public void print()
  {
    System.out.println(fullname);
    System.out.println(age);
  }
  
  /**
   * @return the fullname
   */
  public String getFullname() {
    return fullname;
  }
  /**
   * @param fullname the fullname to set
   */
  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
  /**
   * @return the age
   */
  public int getAge() {
    return age;
  }
  /**
   * @param age the age to set
   */
  public void setAge(int age) {
    this.age = age;
  }
  
}
