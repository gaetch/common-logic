package fr.gaetch.location;

public enum Country implements Location {
	FRANCE,
	GERMANY,
	JAPAN,
	LUXEMBOURG,
	UNITED_KINGDOM,
	UNITED_STATED;

	@Override
	public Precision getPrecision() {
		return Precision.COUNTRY;
	}
}