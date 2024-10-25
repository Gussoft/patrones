package com.gussoft.patrones.estructurales.adapter;

public class CrediCard implements Payment {
  
  PayAdapter adapter;
  
  @Override
  public void pay(String type) {
    if (type.equalsIgnoreCase("classic")) {
      System.out.println("Tarjeta Classic: Pagando sin ningun tipo de Seguridad");
    } else if (type.equalsIgnoreCase("gold")) {
      adapter = new PayAdapter("gold");
      adapter.pay("gold");
    } else if (type.equalsIgnoreCase("black")) {
      adapter = new PayAdapter("black");
      adapter.pay("black");
    } else {
      System.out.println("No se puede realizar el pago ");
    }
  }
}
