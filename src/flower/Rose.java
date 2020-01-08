package flower;

public class Rose extends Flower {

  private String stemLength;

  public Rose() {
  }

  public Rose(int price, String color, String stemLength) {
    super(price, color);
    this.stemLength = stemLength;
  }

  public String getStemLength() {
    return stemLength;
  }

  public void setStemLength(String stemLength) {
    this.stemLength = stemLength;
  }

  @Override
  public String toString() {
    return "Роза: " + getStemLength() + ", " + getColor() + ", цена: " + getPrice() + "р.";
  }
}
