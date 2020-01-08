package exceptions;

public class FlowersException extends Exception {
  protected String message;

  @Override
  public String getMessage() {
    return message;
  }
}
