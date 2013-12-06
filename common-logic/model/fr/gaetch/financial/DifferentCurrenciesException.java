package fr.gaetch.financial;

/**
 * An exception thrown while trying to
 * do an operation on two or more financial objects with different currencies
 * @author Gaetch
 */
public class DifferentCurrenciesException extends FinancialException {
	private static final long serialVersionUID = 8386958681961891369L;

	public DifferentCurrenciesException() {
		super("Different currencies");
	}
}