package fr.gaetch.financial.amount;
import java.math.BigDecimal;
import java.util.Currency;
import fr.gaetch.financial.amount.Amount;
import fr.gaetch.financial.amount.NegativeAmountException;

/**
 * A positive amount of money
 * @author Gaetch
 */
public class PositiveAmount extends Amount {
	public PositiveAmount(String value, Currency currency) {
		this(new BigDecimal(value), currency);
	}

	public PositiveAmount(Amount copiedAmount) {
		this(copiedAmount.value, copiedAmount.currency);
	}

	public PositiveAmount() {
		
	}

	/**
	 * All constructors MUST call this one
	 * because some setting (like scale and rounding mode) are done here
	 * @param value its scale and rounding mode will be set here
	 * @param currency
	 */
	public PositiveAmount(BigDecimal value, Currency currency) {
		if (value.compareTo(BigDecimal.ZERO) < 0) {
			throw new NegativeAmountException();
		}
		else {
			this.value = value.setScale(6, BigDecimal.ROUND_HALF_EVEN);
			this.currency = currency;
		}
	}



	// Validity and compatibility control
	public void checkValidity() {
		super.checkValidity();
		if ((this.value.compareTo(BigDecimal.ZERO) < 0)) {
			throw new NegativeAmountException();
		}
	}



	// Arithmetic operations
	public PositiveAmount add(Amount added) {
		Amount thisCast = new Amount(this);
		Amount sum = thisCast.add(added);
		return new PositiveAmount(sum);
	}

	public PositiveAmount subtract(Amount subtracted) {
		Amount thisCast = new Amount(this);
		Amount difference = thisCast.subtract(subtracted);
		return new PositiveAmount(difference);
	}
}