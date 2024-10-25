package com.gussoft.patrones.estructurales.adapter;

public class PayAdapter implements Payment {

  Secure secure;

  public PayAdapter(String type) {
    if (type.equalsIgnoreCase("black")) {
      secure = new BlackCreditCard();
    } else if (type.equalsIgnoreCase("gold")) {
      secure = new GoldCreditCard();
    }
  }
  @Override
  public void pay(String type) {
    if (type.equalsIgnoreCase("black")) {
      secure.payWithSecureLevelA();
    } else if (type.equalsIgnoreCase("gold")) {
      secure.payWithSecureLevelZ();
    }
  }
}
