package com.gussoft.patrones.creacionales.factorymethod;

public class GooglePayment implements Payment{
  @Override
  public void doPayment() {
    System.out.println("Pagando con Google Payment!");
  }

}
