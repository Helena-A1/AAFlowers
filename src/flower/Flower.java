package flower;

public abstract class Flower {

  private int price;
  private String color;

  public Flower() {
  }

  protected Flower(int price, String color) {
    this.price = price;
    this.color = color;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

}
