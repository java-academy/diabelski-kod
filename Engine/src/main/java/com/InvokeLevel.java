package com;
//TODO change name
public enum InvokeLevel
{

  LOW(1),MEDIUM(2),HIGH(3);

  private final int invokeLevel;

  InvokeLevel(int invokeLevel) {

    this.invokeLevel = invokeLevel;
  }

  public int getInvokeLevel() {
    return invokeLevel;
  }
}
