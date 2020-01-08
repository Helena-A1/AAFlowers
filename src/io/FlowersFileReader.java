package io;

import flower.Flower;
import flower.Iris;
import flower.Lily;
import flower.Rose;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlowersFileReader extends FlowersReader {
  private String fileName;

  public FlowersFileReader(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public List<Flower> read() {
    List<Flower> flowers = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(getFile(fileName)))) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        Flower flower = parseFlower(line);
        if (flower != null) {
          flowers.add(flower);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return flowers;
  }

  private Flower parseFlower(String string) {
    try {
      String[] parameters = string.split(":")[1].trim().split(",");
      if (string.startsWith("Роза:")) {
        Rose rose = new Rose();
        rose.setStemLength(parameters[0].trim());
        rose.setColor(parameters[1].trim());
        rose.setPrice(Integer.parseInt(parameters[2].trim()));
        return rose;
      } else if (string.startsWith("Лилия:")) {
        Lily lily = new Lily();
        lily.setBudAmount(Integer.parseInt(parameters[0].trim()));
        lily.setColor(parameters[1].trim());
        lily.setPrice(Integer.parseInt(parameters[2].trim()));
        return lily;
      } else if (string.startsWith("Ирис:")) {
        Iris iris = new Iris();
        iris.setColor(parameters[0].trim());
        iris.setPrice(Integer.parseInt(parameters[1].trim()));
        return iris;
      } else {
        return null;
      }
    } catch (Exception e) {
      return null;
    }
  }
}
