package com.gussoft.patrones.creacionales.prototype;

import static com.gussoft.patrones.creacionales.prototype.PrototypeFactory.CartType.AMEX;
import static com.gussoft.patrones.creacionales.prototype.PrototypeFactory.CartType.VISA;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

  public static class CartType {
    public static final String VISA = "visa";
    public static final String AMEX = "amex";
  }

  private static Map<String, PrototypeCard> prototypes = new HashMap<>();

  public static PrototypeCard getInstance(final String tipo) throws CloneNotSupportedException {
    return prototypes.get(tipo).clone();
  }

  public static void loadCard() {
    Visa visa = new Visa();
    visa.setName("esta es una tarjeta visa");
    visa.setNumber("con numero 0000 4444 2222 VISA");
    prototypes.put(VISA, visa);

    Amex amex = new Amex();
    amex.setName("esta es una tarjeta amex");
    amex.setNumber("con numero 0000 4444 2222 AMEX");
    prototypes.put(AMEX, amex);
  }
}

