package com.gussoft.patrones.creacionales.factorymethod;

public class DogPayment implements Payment{
  @Override
  public void doPayment() {
    System.out.println("Pagando con Dog Payment");
  }
}
