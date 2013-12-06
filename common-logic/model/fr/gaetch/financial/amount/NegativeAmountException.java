package fr.gaetch.financial.amount;

/**
* An exception thrown while trying to
* assign a negative value to an amount supposed to be positive
* @author Gaetch
*/
public class NegativeAmountException extends InvalidAmountException {
	private static final long serialVersionUID = 139745309889350727L;

	public NegativeAmountException() {
		super("Negative amount");
	}
}