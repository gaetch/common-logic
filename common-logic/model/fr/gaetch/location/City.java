package fr.gaetch.location;

public class City implements Location {
	private final Country country;
	private final String name;

	public City(final Country country, final String name) {
		this.country = country;
		this.name = name;
	}

	public Country getCountry() {
		return this.country;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.country;
	}

	@Override
	public Precision getPrecision() {
		return Precision.CITY;
	}
}