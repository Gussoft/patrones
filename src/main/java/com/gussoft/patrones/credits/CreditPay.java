package com.gussoft.patrones.credits;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditPay {
    public static void main(String[] args) {
      CreditCard creditCard = new CreditCard(BigDecimal.valueOf(1000));

      creditCard.makeTransaction(BigDecimal.valueOf(500));
      creditCard.makeTransaction(BigDecimal.valueOf(300));
      creditCard.makeTransaction(BigDecimal.valueOf(200)); // Esta transacción excederá el límite

      System.out.println("Saldo actual: $" + creditCard.getCurrentBalance());
      System.out.println("Historial de transacciones: " + creditCard.getTransactions());
    }
}

class CreditCard {
  private BigDecimal creditLimit;
  private BigDecimal currentBalance;
  private List<BigDecimal> transactions;

  public CreditCard(BigDecimal creditLimit) {
    this.creditLimit = creditLimit;
    this.currentBalance = BigDecimal.ZERO;
    this.transactions = new ArrayList<>();
  }

  public void makeTransaction(BigDecimal amount) {
    if (currentBalance.add(amount).compareTo(creditLimit) <= 0) {
      transactions.add(amount);
      currentBalance = currentBalance.add(amount);
      System.out.println("Transacción exitosa: $" + amount);
    } else {
      System.out.println("La transacción de $" + amount + " excede el límite de crédito.");
    }
  }

  public BigDecimal getCurrentBalance() {
    return currentBalance;
  }

  public List<BigDecimal> getTransactions() {
    return transactions;
  }
}