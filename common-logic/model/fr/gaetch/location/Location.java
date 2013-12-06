package fr.gaetch.location;

/**
 * Any information used to design a place
 * For the more to the less precise:
 * Address - District - City - Country
 * 
 * @author gaetch
 */
public interface Location {
	public static enum Precision {
		COUNTRY,
		CITY,
		DISTRICT,
		ADDRESS
	}

	public Precision getPrecision();
}