package com.enumTest;

public enum Operation {

  PLUS("+"),
  MINUS("-"),
  TIMES("*"),
  DIVIDE("/");

  private final String symbol;

  Operation(String symbol){
    this.symbol = symbol;
  }

}
