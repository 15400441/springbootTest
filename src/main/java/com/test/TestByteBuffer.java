package com.test;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestByteBuffer {

  public static void main(String[] args){
    test();
  }

  public static void test(){
    ByteBuffer buffer = ByteBuffer.allocate(100);
    buffer.putInt(56);
    buffer.putInt(2);
    buffer.putInt(3);
    System.out.println(Arrays.toString(buffer.array()));
  }
}
