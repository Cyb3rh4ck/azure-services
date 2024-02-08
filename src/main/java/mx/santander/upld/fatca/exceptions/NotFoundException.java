package mx.santander.upld.fatca.exceptions;
public class NotFoundException extends RuntimeException {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6269280006271815874L;

public NotFoundException() {}

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotFoundException(Throwable cause) {
    super(cause);
  }
}