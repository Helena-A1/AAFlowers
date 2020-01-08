package catlog;

import exceptions.ItemNotFoundException;
import flower.Flower;

import java.util.ArrayList;
import java.util.List;

public class FlowerCatalog {

  private List<Item> catalog;

  public FlowerCatalog() {
    this.catalog = new ArrayList<>();
  }

  public void add(Flower flower) {
    Item item = new Item();
    item.setId(catalog.size());
    item.setFlower(flower);
    catalog.add(item);
  }

  public Item getItem(int id) throws ItemNotFoundException {
    try{
      return catalog.get(id);
    } catch (IndexOutOfBoundsException e){
      throw new ItemNotFoundException(id);
    }
  }

  public void showCatalog() {
    System.out.println("Доступныне цветы:");
    for (Item item : catalog) {
      System.out.println(item);
    }
    System.out.println();
  }

}
