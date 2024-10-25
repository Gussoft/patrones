package com.gussoft.patrones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class generador {
  private Long valorActual;

  public generador(long valorInicial) {
    this.valorActual = valorInicial;
  }

  public String generarCuenta() {
    String cuenta = "" + this.valorActual;
    this.valorActual++;
    return cuenta;
  }
  public static void main(String[] args) {
    generador generador = new generador(1245000000000001L);

    // Generar cuentas en serie
    for (int i = 0; i < 1000; i++) {  // Generar 5 cuentas
      String nuevaCuenta = generador.generarCuenta();
      System.out.println("Se ha generado una nueva cuenta: " + nuevaCuenta);
    }

    List<String> account = loadFiles("account");
    account.forEach(e -> e.toString());
  }

  public static List<String> loadFiles(String path) {
    List<String> list = null;
    FileReader fileReader;
    BufferedReader bu;
    String line;
    File carp = new File("Files");
    File file = new File("Files/" + path);
    try {
      if (!carp.exists()) {
        FileUtils.forceMkdir(carp);
      }
      if (!file.exists()) {
        file.createNewFile();
      }
      list = new ArrayList<>();
      fileReader = new FileReader("Files/" + path);
      bu = new BufferedReader(fileReader);
      while ((line = bu.readLine()) != null) {
        list.add(line);
      }
      bu.close();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    return list;
  }
}
