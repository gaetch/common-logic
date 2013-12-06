package fr.gaetch.util.status;

import java.util.HashMap;
import java.util.Map;

/**
 * A series of constants used to insure consistency across various applications
 * Favor over boolean or integer codes to increase readability and maintenance
 * Status or one of its subclasses can be specialized to suit special needs
 * 
 * To avoid confusion, names and codes should be unique among all statuses
 *  
 * @author gaetch
 */
public abstract class Status {
	/** An explicit and simple name */
	private final String name;
	/** An literal short code (3 chars max) */
	private final String code;

	/** map of all status names for search and uniqueness check */
	private static final Map<String, Status> names = new HashMap<String, Status>();
	/** map of all status codes for search and uniqueness check */
	private static final Map<String, Status> codes = new HashMap<String, Status>();

	/**
	 * Statuses are only defined as constants inside Status and subclasses
	 * 
	 * @param name the status name
	 * @param code the status code (3 chars max)
	 */
	protected Status(final String name, final String code) {
		assert 1 <= name.length() && name.length() <= 3;
		names.put(name, this);
		codes.put(code, this);

		this.name = name;
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}

	public abstract boolean isOk();

	public String toString() {
		return this.name;
	}

	public static Status findByName(String name) {
		return names.get(name);
	}

	public static Status findByCode(String code) {
		return codes.get(code);
	}
}