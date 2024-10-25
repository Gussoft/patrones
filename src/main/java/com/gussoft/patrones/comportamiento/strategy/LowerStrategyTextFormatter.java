package com.gussoft.patrones.comportamiento.strategy;

public class LowerStrategyTextFormatter implements StrategyTextFormatter{
  @Override
  public void format(String text) {
    System.out.println("Texto en Minusculas : " + text.toLowerCase());
  }
}
