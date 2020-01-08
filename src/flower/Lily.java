package flower;

public class Lily extends Flower {
  private int budAmount;

  public Lily() {
  }

  public Lily(int price, String color, int budAmount) {
    super(price, color);
    this.budAmount = budAmount;
  }

  public int getBudAmount() {
    return budAmount;
  }

  public void setBudAmount(int budAmount) {
    this.budAmount = budAmount;
  }

  @Override
  public String toString() {
    return "Лилия: кол-во бутонов:" + getBudAmount() + ", " + getColor() + ", цена: " + getPrice() + "р.";
  }

}
