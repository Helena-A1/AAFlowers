package flower;

public class Iris extends Flower {

  public Iris() {
  }

  public Iris(int price, String color) {
    super(price, color);
  }

  @Override
  public String toString() {
    return "Ирис: " + getColor() + ", цена: " + getPrice() + "р.";
  }

}
