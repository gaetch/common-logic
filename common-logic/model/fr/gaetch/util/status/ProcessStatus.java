package fr.gaetch.util.status;

/**
 * A status set used to represent all steps of a process
 * 
 * @author gaetch
 */
public class ProcessStatus extends BinaryStatus {
	public static final ProcessStatus IDLE = new ProcessStatus("IDLE", "IDL");
	public static final ProcessStatus ONGOING = new ProcessStatus("IDLE", "ONG");

	protected ProcessStatus(final String name, final String code) {
		super(name, code);
	}

	/**
	 * Indicates the process has started
	 * 
	 * @return boolean
	 *	true if the process has started
	 *	false if the process hasn't started yet 
	 */
	public boolean hasStarted() {
		return !this.equals(IDLE);
	}

	/**
	 * Indicates the process has ended, either in a good or bad way
	 * 
	 * @return boolean
	 *	true if the process has ended
	 *	false if the process hasn't started or is still ongoing 
	 */
	public boolean hasEnded() {
		return this.equals(OK) || this.equals(NOK);
	}
}