package fr.gaetch.util.status;

/**
 * A status set used to represent the status of a message
 *  
 * @author gaetch
 */
public class MessageStatus extends Status {
	public static final MessageStatus ERROR = new MessageStatus("ERROR", "ERR");
	public static final MessageStatus WARNING = new MessageStatus("WARNING", "WRN");
	public static final MessageStatus INFO = new MessageStatus("INFO", "INF");

	protected MessageStatus(final String name, final String code) {
		super(name, code);
	}

	@Override
	public boolean isOk() {
		return this.equals(INFO);
	}
}