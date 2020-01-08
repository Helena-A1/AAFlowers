package io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import flower.Flower;
import flower.Iris;
import flower.Lily;
import flower.Rose;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlowersJsonReader extends FlowersReader {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private static final String ROSES = "json/roses.json";
  private static final String LILIES = "json/lilies.json";
  private static final String IRISES = "json/irises.json";

  @Override
  public List<Flower> read() {
    List<Flower> flowers = new ArrayList<>();
    try {
      flowers.addAll(OBJECT_MAPPER.readValue(getFile(ROSES), getCollectionType(Rose.class)));
      flowers.addAll(OBJECT_MAPPER.readValue(getFile(LILIES), getCollectionType(Lily.class)));
      flowers.addAll(OBJECT_MAPPER.readValue(getFile(IRISES), getCollectionType(Iris.class)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return flowers;
  }

  private CollectionType getCollectionType(Class<?> clazz) {
    return OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz);
  }

}
