package catlog;

import flower.Flower;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
  private List<Flower> flowers;

  public Bouquet() {
    flowers = new ArrayList<>();
  }

  public void add(Flower flower) {
    flowers.add(flower);
  }

  public int getTotalPrice() {
    int totalPrice = 0;
    for (Flower flower : flowers) {
      totalPrice += flower.getPrice();
    }
    return totalPrice;
  }
}
