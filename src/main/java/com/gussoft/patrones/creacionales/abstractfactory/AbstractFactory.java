package com.gussoft.patrones.creacionales.abstractfactory;

public interface AbstractFactory<T> {

  T create(String type);

}
