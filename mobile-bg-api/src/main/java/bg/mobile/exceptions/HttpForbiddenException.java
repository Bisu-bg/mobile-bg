package bg.mobile.exceptions;

public class HttpForbiddenException extends RuntimeException {

  public HttpForbiddenException(final String message) {
    super(message);
  }

  public HttpForbiddenException() {
  }
}