package bg.mobile.exceptions;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(HttpUnauthorizedException.class)
  public void httpUnauthorizedException(final HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.UNAUTHORIZED.value());
  }

  @ExceptionHandler(HttpForbiddenException.class)
  public void httpForbiddenException(final HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.FORBIDDEN.value());
  }

  @ExceptionHandler(HttpBadRequestException.class)
  public void httpBadRequestException(final HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }
}