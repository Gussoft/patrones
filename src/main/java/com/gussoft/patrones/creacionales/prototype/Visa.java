package com.gussoft.patrones.creacionales.prototype;

public class Visa implements PrototypeCard {

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
    System.out.println("Clonando tarjeta Visa...");
    return (Visa) super.clone();
  }

  @Override
  public void getCard() {
    System.out.println("Esto es una tarjeta Visa!");
  }
}
