package runner;

import catlog.Bouquet;
import catlog.FlowerCatalog;
import exceptions.FlowersException;
import exceptions.ItemNotFoundException;
import exceptions.UnexpectedFlowersCountException;
import exceptions.UnknownAnswerException;
import flower.Flower;
import flower.Iris;
import flower.Lily;
import flower.Rose;
import io.FlowersFileReader;
import io.FlowersJsonReader;
import io.FlowersReader;

import java.util.List;
import java.util.Scanner;

public class Runner {
  private static Scanner scanner;

  public static void main(String[] args) {
    FlowerCatalog catalog = new FlowerCatalog();
//    fillFlowers(catalog);
//    fillFlowers(catalog, new FlowersFileReader("items.txt"));
    fillFlowers(catalog, new FlowersJsonReader());
    System.out.println("Welcome!");
    System.out.println();
    catalog.showCatalog();

    boolean proceed = true;

    while (proceed) {
      scanner = new Scanner(System.in);

      System.out.print("Вы хотите составить букет? [y/n]: ");
      String answer = scanner.nextLine();

      try {
        if (answer.equals("y")) {
          Bouquet bouquet = new Bouquet();
          System.out.print("Колличество цветов в букете: ");
          int flowersCount = scanner.nextInt();
          if (flowersCount < 1) {
            throw new UnexpectedFlowersCountException();
          }
          for (int i = 0; i < flowersCount; i++) {
            Flower flower = chooseFlower(catalog);
            bouquet.add(flower);
          }
          System.out.println("Цена вашего букета: " + bouquet.getTotalPrice() + "р.");
        } else if (answer.equals("n")) {
          proceed = false;
        } else {
          throw new UnknownAnswerException();
        }
      } catch (FlowersException e) {
        System.out.println(e.getMessage());
      }
    }
    System.out.println("До свидания, приходите к нам ещё!");
  }

  private static void fillFlowers(FlowerCatalog catalog, FlowersReader reader) {
    List<Flower> flowers = reader.read();
    for (Flower flower : flowers) {
      catalog.add(flower);
    }
  }

  private static void fillFlowers(FlowerCatalog catalog) {
    catalog.add(new Rose(5, "красная", "маленькая"));
    catalog.add(new Rose(6, "красная", "средняя"));
    catalog.add(new Rose(7, "красная", "большая"));
    catalog.add(new Rose(5, "белая", "маленькая"));
    catalog.add(new Rose(6, "белая", "средняя"));
    catalog.add(new Rose(7, "белая", "большая"));
    catalog.add(new Lily(7, "белая", 3));
    catalog.add(new Lily(8, "белая", 4));
    catalog.add(new Lily(9, "белая", 5));
    catalog.add(new Lily(7, "розовая", 3));
    catalog.add(new Lily(8, "розовая", 4));
    catalog.add(new Lily(9, "розовая", 5));
    catalog.add(new Iris(4, "blue"));
    catalog.add(new Iris(4, "purple"));
  }

  private static Flower chooseFlower(FlowerCatalog catalog) {
    Flower flower = null;
    boolean proceed = true;
    while (proceed) {
      System.out.print("Введите номер цветка: ");
      int flowerId = scanner.nextInt();
      try {
        flower = catalog.getItem(flowerId).getFlower();
        proceed = false;
      } catch (ItemNotFoundException e) {
        System.out.println(e.getMessage());
      }
    }
    return flower;
  }
}
