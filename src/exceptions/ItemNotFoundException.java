package exceptions;

public class ItemNotFoundException extends FlowersException {

  public ItemNotFoundException(int id) {
    message = "Товар с id=" + id + " не найден.";
  }

}
