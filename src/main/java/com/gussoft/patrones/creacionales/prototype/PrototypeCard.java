package com.gussoft.patrones.creacionales.prototype;

public interface PrototypeCard extends Cloneable {

  PrototypeCard clone() throws  CloneNotSupportedException;

  void getCard();

}
