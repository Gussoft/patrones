package com.gussoft.patrones.creacionales.prototype;

public class Amex implements PrototypeCard{
  private String name;
  private String number;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  public PrototypeCard clone() throws CloneNotSupportedException {
    System.out.println("Clonando tarjeta Amex...");
    return (Amex) super.clone();
  }

  @Override
  public void getCard() {
    System.out.println("Esto es una tarjeta Amex!");
  }
}
