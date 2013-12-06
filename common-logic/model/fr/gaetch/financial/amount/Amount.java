package fr.gaetch.financial.amount;
import java.math.BigDecimal;
import java.util.Currency;
import fr.gaetch.financial.DifferentCurrenciesException;
import fr.gaetch.financial.amount.InvalidAmountException;

/**
 * An amount of money
 * with a value and a currency
 * @author Gaetch
 */
public class Amount {
	protected BigDecimal value;
	protected Currency currency;

	public BigDecimal getValue() {
		return this.value;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	/*
	 * No setters because
	 * currency should not be changed after instantiation
	 * and value should only be changed via arithmetic operations
	 */

	/**
	 * Should never be called.
	 * Present for Hibernate instantiation.
	 */
	public Amount() {
		
	}

	public Amount(String stringAmount) {
		this(
			stringAmount.substring(0, stringAmount.length() - 3),
			Currency.getInstance(stringAmount.substring(stringAmount.length() - 3))
		);
	}

	public Amount(String value, Currency currency) {
		this(new BigDecimal(value), currency);
	}

	public Amount(Amount copiedAmount)	{
		this(copiedAmount.value, copiedAmount.currency);
	}

	/**
	 * All constructors MUST call this one
	 * because some setting (like scale and rounding mode) are done here
	 * @param value its scale and rounding mode will be set here
	 * @param currency
	 */
	public Amount(BigDecimal value, Currency currency) {
		/*
		 * Scale and rounding mode are set here, so they're the same for every amount.
		 * A scale of 6 allows to work with every financial object.
		 */
		this.value = value.setScale(6, BigDecimal.ROUND_HALF_EVEN);
		this.currency = currency;
	}



	@Override
	public String toString() {
		return this.value.toString() + this.currency.toString();
	}

	/**
	 * Returns a string of fixed length representing the amount.
	 * Format +NNNNNNNNN.NNNNNN for a positive amount
	 * and    -NNNNNNNNN.NNNNNN for a negative amount
	 * @return fixed string amount
	 */
	public String toFixedString() {
		String model = "000000000.000000";
		int modelLength = model.length();

		String sign = (this.value.signum() == -1 ? "-" : "+");

		String value = this.value.abs().toString();
		int length = value.length();

		String paddedValue = model.substring(0, modelLength - length) + value;

		String currency = this.currency.toString();

		return
			sign +
			paddedValue +
			currency;
	}



	// Comparison
	public int compareTo(Amount compared) {
		this.checkValidity();
		compared.checkValidity();
		this.checkCompatibility(compared);

		return this.value.compareTo(compared.value);
	}

	@Override
	public boolean equals(Object compared) {
		boolean comparison = false;

		this.checkValidity();

		if (compared instanceof Amount) {
			Amount comparedAmount = (Amount) compared;
			comparedAmount.checkValidity();

			comparison = (this.value.equals(comparedAmount.value) && this.currency.equals(comparedAmount.currency));
		}

		return comparison;
	}

	@Override
	public int hashCode() {
		return ((this.value.hashCode() + this.currency.hashCode()) / 2);
	}



	// Validity and compatibility control
	public void checkValidity() {
		if ((this.value == null) || (this.currency == null)) {
			throw new InvalidAmountException();
		}
	}

	public void checkCompatibility(Amount compared) {
		if (!this.currency.equals(compared.currency)) {
			throw new DifferentCurrenciesException();
		}
	}



	// Arithmetic operations
	public Amount add(Amount added) {
		this.checkValidity();
		added.checkValidity();
		this.checkCompatibility(added);

		return new Amount(this.value.add(added.value), this.currency);
	}

	public Amount subtract(Amount subtracted) {
		this.checkValidity();
		subtracted.checkValidity();
		this.checkCompatibility(subtracted);

		return new Amount(this.value.subtract(subtracted.value), this.currency);
	}

	public Amount negate() {
		return new Amount(this.value.negate(), this.currency);
	}

	/**
	 * Compares the value of this amount to zero,
	 * regardless of its currency.
	 * @return true if this amount's value equals zero or not, false otherwise
	 */
	public boolean isZero() {
		return this.equals(new Amount(BigDecimal.ZERO, this.currency));
	}
}