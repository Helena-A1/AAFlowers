package catlog;

import flower.Flower;

public class Item {
  private int id;
  private Flower flower;

  public int getId() {

    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Flower getFlower() {
    return flower;
  }

  public void setFlower(Flower flower) {
    this.flower = flower;
  }

  @Override
  public String toString() {
    return id + ": " + flower;
  }
}
