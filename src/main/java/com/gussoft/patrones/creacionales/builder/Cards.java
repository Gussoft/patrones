package com.gussoft.patrones.creacionales.builder;

public class Cards {
  private final String cardType;
  private final String number;
  private final String name;
  private final int expires;
  private final boolean credit;

  private Cards(CardBuilder builder) {
    this.name = builder.name;
    this.number = builder.number;
    this.cardType = builder.cardType;
    this.expires = builder.expires;
    this.credit = builder.credit;
  }

  public String getCardType() {
    return cardType;
  }

  public String getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }

  public int getExpires() {
    return expires;
  }

  public boolean isCredit() {
    return credit;
  }

  @Override
  public String toString() {
    return "Cards{" +
      "cardType='" + cardType + '\'' +
      ", number='" + number + '\'' +
      ", name='" + name + '\'' +
      ", expires=" + expires +
      ", credit=" + credit +
      '}';
  }

  public static class CardBuilder {
    private String cardType;
    private String number;
    private String name;
    private int expires;
    private boolean credit;

    public CardBuilder(String cardType, String number) {
      this.cardType = cardType;
      this.number = number;
    }

    public CardBuilder name(String name) {
      this.name = name;
      return this;
    }
    public CardBuilder expires(int expires) {
      this.expires = expires;
      return this;
    }
    public CardBuilder credit(boolean credit) {
      this.credit = credit;
      return this;
    }

    public Cards build() {
      return new Cards(this);
    }
  }
}
