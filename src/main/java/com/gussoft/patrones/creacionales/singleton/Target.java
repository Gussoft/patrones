package com.gussoft.patrones.creacionales.singleton;

public class Target {

  private static Target Instance;
  private String numbers;

  private Target() {

  }

  public synchronized static Target getInstance() {
    if (Instance == null) {
      Instance = new Target();
    }
    return Instance;
  }

  public String getNumbers() {
    return numbers;
  }

  public void setNumbers(String numbers) {
    this.numbers = numbers;
  }

}
