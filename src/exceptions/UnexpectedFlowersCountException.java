package exceptions;

public class UnexpectedFlowersCountException extends FlowersException {
  public UnexpectedFlowersCountException() {
    message = "Невалидный ответ.";
  }
}
