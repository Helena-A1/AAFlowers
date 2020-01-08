package exceptions;

public class UnknownAnswerException extends FlowersException {

  public UnknownAnswerException() {
    message = "Неизвестный вариант ответа.";
  }

}
