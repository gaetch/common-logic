package fr.gaetch.financial.amount;
import fr.gaetch.financial.FinancialException;

/**
 * An exception thrown while trying to
 * use an amount that has not been correctly instanced
 * @author Gaetch
 */
public class InvalidAmountException extends FinancialException {
	private static final long serialVersionUID = -5773848652115329826L;

	public InvalidAmountException() {
		this("Invalid amount");
	}

	public InvalidAmountException(String message) {
		super(message);
	}
}