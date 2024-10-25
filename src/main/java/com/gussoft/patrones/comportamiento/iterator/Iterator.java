package com.gussoft.patrones.comportamiento.iterator;

public interface Iterator {

  boolean hasNext();

  Object next();

  Object currentItem();

}
