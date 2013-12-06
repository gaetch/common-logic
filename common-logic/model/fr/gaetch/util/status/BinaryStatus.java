package fr.gaetch.util.status;

/**
 * The simplest status set: OK and NOK should be used to replace booleans
 * for scalability reasons
 * 
 * @author gaetch
 */
public class BinaryStatus extends Status {
	public static final BinaryStatus NOK = new BinaryStatus("NOK", "NOK");
	public static final BinaryStatus OK = new BinaryStatus("OK", "OK");

	protected BinaryStatus(final String name, final String code) {
		super(name, code);
	}

	@Override
	public boolean isOk() {
		return this.equals(OK);
	}
}