package fr.gaetch.system.exception;

/**
 * A generic custom exception
 * @author Gaetch
 */
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = -6930409369909886825L;

	public CustomException(String message) {
		super(message);
	}
}