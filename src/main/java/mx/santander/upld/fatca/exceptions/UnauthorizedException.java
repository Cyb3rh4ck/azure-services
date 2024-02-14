package mx.santander.upld.fatca.exceptions;

public class UnauthorizedException extends RuntimeException {

	/**
	 * @author @author x661902
	 * 
	 * clase que cacha un Unauthorized exception
	 */
	private static final long serialVersionUID = 2415028383589597412L;
	
	public UnauthorizedException() {}
	
	public UnauthorizedException(String message) {
		super(message);
	}
	
	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UnauthorizedException(Throwable cause) {
		super(cause);
	}
	
}
