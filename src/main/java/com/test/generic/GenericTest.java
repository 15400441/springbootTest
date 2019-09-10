package com.test.generic;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GenericTest {


  @Test
  public void wildCardTest(){

    Map<String,Object> anyValueMap = new HashMap<>();


    anyValueMap.put("apple","delicious");
    anyValueMap.put("apple",1);


    System.out.println(anyValueMap);

  }


}
