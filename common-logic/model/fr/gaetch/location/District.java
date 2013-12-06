package fr.gaetch.location;

public class District implements Location {
	private final City city;
	private final ZipCode zipCode;

	public District(final City city, final ZipCode zipCode) {
		this.city = city;
		this.zipCode = zipCode;
	}

	public City getCity() {
		return this.city;
	}

	public ZipCode getZipCode() {
		return this.zipCode;
	}

	@Override
	public String toString() {
		return this.zipCode + " " + this.city;
	}

	@Override
	public Precision getPrecision() {
		return Precision.DISTRICT;
	}
}