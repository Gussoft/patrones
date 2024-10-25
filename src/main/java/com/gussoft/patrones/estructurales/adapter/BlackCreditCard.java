package com.gussoft.patrones.estructurales.adapter;

public class BlackCreditCard implements Secure{
  @Override
  public void payWithSecureLevelA() {
    System.out.println("Tarjeta Black: Pagando con seguridad Alta");
  }

  @Override
  public void payWithSecureLevelZ() {

  }
}
