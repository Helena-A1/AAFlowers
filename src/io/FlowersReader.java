package io;

import flower.Flower;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class FlowersReader {
  abstract public List<Flower> read();

  protected File getFile(String fileName) {
    return new File(getClass().getClassLoader().getResource(fileName).getFile());
  }
}
