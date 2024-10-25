package com.gussoft.patrones.credits;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Calculate {
  public static void main(String[] args) {
    BigDecimal principal = BigDecimal.valueOf(10500);
    double annualInterestRate = 12.7038; // Tasa de interés anual del 5%
    int numberOfMonths = 12;

    List<BigDecimal> payments = calculateMonthlyPayments(principal, annualInterestRate, numberOfMonths);

    System.out.println("Pagos mensuales:");
    for (int i = 0; i < payments.size(); i++) {
      System.out.println("Mes " + (i + 1) + ": $" + payments.get(i));
    }
  }
  public static List<BigDecimal> calculateMonthlyPayments(BigDecimal principal, double annualInterestRate, int numberOfMonths) {
    List<BigDecimal> monthlyPayments = new ArrayList<>();
    BigDecimal monthlyInterestRate = BigDecimal.valueOf(annualInterestRate / 12 / 100);

    for (int month = 1; month <= numberOfMonths; month++) {
      BigDecimal numerator = monthlyInterestRate.multiply(principal);
      BigDecimal denominator = BigDecimal.valueOf(Math.pow(1 + monthlyInterestRate.doubleValue(), numberOfMonths - month + 1) - 1);

      BigDecimal monthlyPayment = numerator.divide(denominator, 2, RoundingMode.HALF_UP);
      monthlyPayments.add(monthlyPayment);
    }

    return monthlyPayments;
  }
}
