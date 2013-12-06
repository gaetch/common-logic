package fr.gaetch.financial;
import fr.gaetch.system.exception.CustomException;

/**
 * A generic financial exception
 * @author Gaetch
 */
public abstract class FinancialException extends CustomException {
	private static final long serialVersionUID = -3438348551880052901L;

	public FinancialException(String message) {
		super(message);
	}
}