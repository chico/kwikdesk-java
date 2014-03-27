/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.exception;

import static java.lang.String.format;

public class KwikDeskException extends RuntimeException {

  protected static final long serialVersionUID = 1L;

  public KwikDeskException(String msg) {
    super(msg);
  }

  public KwikDeskException(String msg, Throwable ex) {
    super(msg, ex);
  }

  public KwikDeskException(String url, int statusCode, String errorResponse) {
    super(format("[url: %s, error code: %d, response: %s]", url, statusCode, errorResponse));
  }

}
