package com.gussoft.patrones.creacionales.abstractfactory;

public class Visa implements Card {
  @Override
  public String getCardNumber() {
    return "0000 0000 0000 VISA";
  }

  @Override
  public String getCardType() {
    return "VISA";
  }
}
