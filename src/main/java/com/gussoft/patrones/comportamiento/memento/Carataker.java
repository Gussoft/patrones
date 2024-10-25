package com.gussoft.patrones.comportamiento.memento;

import java.util.ArrayList;
import java.util.List;

public class Carataker {

  private List<ArticleMemento> state = new ArrayList<>();

  public void addMemento(ArticleMemento memento) {
    state.add(memento);
  }

  public ArticleMemento getMemento(int index) {
    return state.get(index);
  }
}
