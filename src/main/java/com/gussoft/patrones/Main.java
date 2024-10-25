package com.gussoft.patrones;

import static com.gussoft.patrones.creacionales.prototype.PrototypeFactory.CartType.AMEX;
import static com.gussoft.patrones.creacionales.prototype.PrototypeFactory.CartType.VISA;

import com.gussoft.patrones.comportamiento.command.CreditCard;
import com.gussoft.patrones.comportamiento.command.CreditCardActivateCommand;
import com.gussoft.patrones.comportamiento.command.CreditCardDesactivateCommand;
import com.gussoft.patrones.comportamiento.command.CreditCardInvoker;
import com.gussoft.patrones.comportamiento.interpreter.AndExpression;
import com.gussoft.patrones.comportamiento.interpreter.Expression;
import com.gussoft.patrones.comportamiento.interpreter.OrExpression;
import com.gussoft.patrones.comportamiento.interpreter.TerminalExpression;
import com.gussoft.patrones.comportamiento.iterator.Cube;
import com.gussoft.patrones.comportamiento.iterator.CubeList;
import com.gussoft.patrones.comportamiento.iterator.GList;
import com.gussoft.patrones.comportamiento.iterator.Iterator;
import com.gussoft.patrones.comportamiento.mediator.ConcreteColleage;
import com.gussoft.patrones.comportamiento.mediator.ConcreteColleage2;
import com.gussoft.patrones.comportamiento.mediator.ConcreteMediator;
import com.gussoft.patrones.comportamiento.memento.Article;
import com.gussoft.patrones.comportamiento.memento.ArticleMemento;
import com.gussoft.patrones.comportamiento.memento.Carataker;
import com.gussoft.patrones.comportamiento.observer.Coche;
import com.gussoft.patrones.comportamiento.observer.MessagePublisher;
import com.gussoft.patrones.comportamiento.observer.Peaton;
import com.gussoft.patrones.comportamiento.observer.Semaforo;
import com.gussoft.patrones.comportamiento.state.MobileAlertState;
import com.gussoft.patrones.comportamiento.state.MobileAlertStateContext;
import com.gussoft.patrones.comportamiento.state.Silent;
import com.gussoft.patrones.comportamiento.state.Vibration;
import com.gussoft.patrones.comportamiento.strategy.CapitalStrategyTextFormatter;
import com.gussoft.patrones.comportamiento.strategy.Context;
import com.gussoft.patrones.comportamiento.strategy.LowerStrategyTextFormatter;
import com.gussoft.patrones.creacionales.abstractfactory.AbstractFactory;
import com.gussoft.patrones.creacionales.abstractfactory.Card;
import com.gussoft.patrones.creacionales.abstractfactory.FactoryProvider;
import com.gussoft.patrones.creacionales.abstractfactory.PaymentMethod;
import com.gussoft.patrones.creacionales.builder.Cards;
import com.gussoft.patrones.comportamiento.chainofresponsibility.Tarjeta;
import com.gussoft.patrones.creacionales.factorymethod.Payment;
import com.gussoft.patrones.creacionales.factorymethod.PaymentFactory;
import com.gussoft.patrones.creacionales.factorymethod.TypePayment;
import com.gussoft.patrones.creacionales.prototype.PrototypeCard;
import com.gussoft.patrones.creacionales.prototype.PrototypeFactory;
import com.gussoft.patrones.creacionales.singleton.Target;
import com.gussoft.patrones.estructurales.adapter.CrediCard;
import com.gussoft.patrones.estructurales.bridge.ClassicCreditCard;
import com.gussoft.patrones.estructurales.bridge.SecuredCreditCard;
import com.gussoft.patrones.estructurales.bridge.UnSecureCreditCard;
import com.gussoft.patrones.estructurales.composite.AccountComponent;
import com.gussoft.patrones.estructurales.composite.AccountComposite;
import com.gussoft.patrones.estructurales.composite.CurrentAccount;
import com.gussoft.patrones.estructurales.composite.SavingsAccount;
import com.gussoft.patrones.estructurales.decorator.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    //System.out.println(demoNumbers());

    //CREACIONALES
    //testFactory();
    //testAbstractFactory();
    //testBuilder();
    //testPrototype();
    //testSingleton();

    //COMPORTAMIENTO
    //textChainOfResponsability();
    //testCommand();
    //testIterator();
    //testMediator();
    //testMemento();
    //testObserver();
    //testState();
    //testInterpreter();
    //testStrategy();

    //ESTRUCTURALES
    //testAdapter();
    //testBridge();
    //testComposite();
    testDecorator();
  }

  private static void testDecorator() {
    Credit gold = new Gold();
    Credit blackInternational = new Black();
    blackInternational = new InternationalPaymentDecorator(blackInternational);

    Credit goldSecureInternational = new Gold();
    goldSecureInternational = new InternationalPaymentDecorator(goldSecureInternational);
    goldSecureInternational = new SecureDecorator(goldSecureInternational);

    System.out.println("--- Tarjeta Gold ---");
    gold.showCredit();
    System.out.println("--- Tarjeta Black International ---");
    blackInternational.showCredit();
    System.out.println("--- Tarjeta Gold International Secure---");
    goldSecureInternational.showCredit();
  }

  private static void testComposite() {
    AccountComponent ca = new SavingsAccount(500.0, "Frans Mendoza");
    AccountComponent cc = new CurrentAccount(850.0, "Frans Mendoza");

    AccountComposite composite = new AccountComposite();
    composite.addAccount(ca);
    composite.addAccount(cc);

    composite.showAccountName();
    composite.getAmount();
  }

  private static void testBridge() {
    com.gussoft.patrones.estructurales.bridge.CreditCard classic = new ClassicCreditCard(new UnSecureCreditCard());
    classic.realizarPago();
    classic = new ClassicCreditCard(new SecuredCreditCard());
    classic.realizarPago();
  }
  private static void testAdapter() {
    CrediCard crediCard = new CrediCard();
    crediCard.pay("classic");
    crediCard.pay("gold");
    crediCard.pay("black");
    crediCard.pay("silver");
  }

  private static void testStrategy() {
    Context context = new Context(new CapitalStrategyTextFormatter());
    context.publishText("Este texto sera convertido en mayusculas perro");

    context = new Context(new LowerStrategyTextFormatter());
    context.publishText("ESTE TEXTO SERA CONVERTIDO A MINUSCULAS PERRO sabe");
  }

  private static void testInterpreter() {
    Expression zero = new TerminalExpression("0");
    Expression one = new TerminalExpression("1");

    Expression containOr = new OrExpression(zero, one);
    Expression cotrainsOrAnd = new AndExpression(zero, one);

    System.out.println(containOr.interpret("zero"));
    System.out.println(containOr.interpret("0"));

    System.out.println(cotrainsOrAnd.interpret("0"));
    System.out.println(cotrainsOrAnd.interpret("0, 1"));
  }

  private static void testState() {
    MobileAlertStateContext context = new MobileAlertStateContext();
    context.alert();
    context.alert();
    context.setState(new Vibration());
    context.alert();
    context.alert();
    context.setState(new Silent());
    context.alert();
  }

  private static void testObserver() {
    Coche coche = new Coche();
    Peaton peaton = new Peaton();
    MessagePublisher messagePublisher = new MessagePublisher();
    messagePublisher.attach(coche);
    messagePublisher.attach(peaton);
    messagePublisher.notifyUpdate(new Semaforo("ROJO_COCHE"));
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    messagePublisher.notifyUpdate(new Semaforo("VERDE_COCHE"));
  }

  private static void testMemento() {
    Carataker carataker = new Carataker();
    Article article = new Article("Guss", "una pregunta de moda");
    article.setText(article.getText() + " decia mi buen bro");
    System.out.println("article = " + article.getText());
    carataker.addMemento(article.createMemento());
    article.setText(article.getText() + "como seria la vida sin perros");
    System.out.println(article.getText());

    carataker.addMemento(article.createMemento());

    article.setText(article.getText() + " algo inapropiado");
    System.out.println(article.getText());

    ArticleMemento m1 = carataker.getMemento(0);
    ArticleMemento m2 = carataker.getMemento(1);

    article.restoreMemento(m1);
    System.out.println(article.getText());
    article.restoreMemento(m2);
    System.out.println(article.getText());

    article.setText(article.getText() +  "sabee!");
  }

  private static void testMediator() {
    ConcreteMediator mediator = new ConcreteMediator();
    ConcreteColleage u1 = new ConcreteColleage(mediator);
    ConcreteColleage2 u2 = new ConcreteColleage2(mediator);

    mediator.setUser1(u1);
    mediator.setUser2(u2);

    u1.send("Hola Wachin acm1pt");
    u2.send("Oleme el dedo, sabee");
  }

  private static void testIterator() {
    Cube[] cubes = new Cube[5];
    cubes[0] = new Cube("VISA");
    cubes[1] = new Cube("AMEX");
    cubes[2] = new Cube("MASTER CARD");
    cubes[3] = new Cube("PAYPAL");
    cubes[4] = new Cube("AMERICAN EXPRESS");

    GList list = new CubeList(cubes);
    Iterator iterator = list.iterator();

    while (iterator.hasNext()) {
      Cube target = (Cube) iterator.next();
      System.out.println(target.getType());
    }
  }

  private static void testCommand() {
    CreditCard creditCard = new CreditCard();
    CreditCard creditCardDesac = new CreditCard();

    CreditCardInvoker invoker = new CreditCardInvoker();
    invoker.setCommand(new CreditCardActivateCommand(creditCard));
    invoker.run();
    System.out.println("***************************************");
    invoker.setCommand(new CreditCardDesactivateCommand(creditCardDesac));
    invoker.run();
  }

  private static void testFactory() {
    Payment payment = PaymentFactory.builPayment(TypePayment.CARD);
    payment.doPayment();
    Payment payment2 = PaymentFactory.builPayment(TypePayment.GOOGLEPAY);
    payment2.doPayment();
    Payment payment3 = PaymentFactory.builPayment(TypePayment.DOGPAY);
    payment3.doPayment();
  }

  private static void testAbstractFactory() {
    AbstractFactory factory = FactoryProvider.getFactory("Card");
    Card cardVisa = (Card) factory.create("VISA");
    AbstractFactory factory1 = FactoryProvider.getFactory("PaymentMethod");
    PaymentMethod method = (PaymentMethod) factory1.create("DEBIT");

    System.out.println("Tarjeta de Tipo " + cardVisa.getCardType() + " : metodo de pago : " + method.doPayment());
  }

  private static void testBuilder() {
    Cards cards = new Cards.CardBuilder("VISA", "0000 1111 4444 VISA")
      .name("Guss")
      .expires(2030)
      .credit(true).build();

    Cards cards2 = new Cards.CardBuilder("MASTERCAR", "0000 1111 44 MASTER").build();
    System.out.println("cards = " + cards);
    System.out.println("cards2 = " + cards2);
  }

  private static void  testPrototype() {
    PrototypeFactory.loadCard();
    try {
      PrototypeCard visa = PrototypeFactory.getInstance(VISA);
      visa.getCard();

      PrototypeCard amex = PrototypeFactory.getInstance(AMEX);
      amex.getCard();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }

  private static void testSingleton() {
    Target target = Target.getInstance();
    target.setNumbers("25658542");
    System.out.println("numbers : " + target.getNumbers());
  }

  private static void textChainOfResponsability() {
    Tarjeta tarjeta = new Tarjeta();
    tarjeta.creditCardRequest(51000);
  }
}
