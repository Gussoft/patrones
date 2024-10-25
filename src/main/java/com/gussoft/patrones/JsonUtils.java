package com.gussoft.patrones;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.IOException;
import java.util.ArrayList;

public class JsonUtils {

  public static void main(String[] args) {
    CuentaBancaria cb = new CuentaBancaria();
    cb.setIbanCliente("Inter");
    String json = JsonUtils.toJson(cb);
    System.out.println("Json : " + json);
    CuentaBancaria res = (CuentaBancaria) fromJson(json, CuentaBancaria.class);
    System.out.println("Obj : " + res);
  }

  public static String toJson(Object obj) {
    String json = null;
    try {
      ObjectMapper mapper = new ObjectMapper();
      json = mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return json;
  }

  public static <T> Object fromJson(String json, Class<T> classType) {
    Object obj = null;
    try {
      ObjectMapper mapper = new ObjectMapper();
      obj = mapper.readValue(json, classType);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return obj;
  }

}
