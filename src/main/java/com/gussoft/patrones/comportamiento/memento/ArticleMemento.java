package com.gussoft.patrones.comportamiento.memento;

public class ArticleMemento {
  private String autor;
  private String text;

  public ArticleMemento(String autor, String text) {
    this.autor = autor;
    this.text = text;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
