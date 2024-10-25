package com.gussoft.patrones.creacionales.abstractfactory;

public class MasterCard implements Card {
  @Override
  public String getCardNumber() {
    return "0000 0000 0000 MAST";
  }

  @Override
  public String getCardType() {
    return "MASTER CARD";
  }
}
