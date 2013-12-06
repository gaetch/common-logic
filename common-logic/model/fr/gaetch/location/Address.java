package fr.gaetch.location;

public class Address implements Location {
	private final String number;
	private final RoadType roadType;
	private final String roadName;
	private final District district;

	public Address(final String number, final RoadType roadType, final String roadName, final District district) {
		this.number = number;
		this.roadType = roadType;
		this.roadName = roadName;
		this.district = district;
	}

	public String getNumber() {
		return this.number;
	}

	public RoadType getRoadType() {
		return this.roadType;
	}

	public String getRoadName() {
		return this.roadName;
	}

	public District getDistrict() {
		return this.district;
	}

	@Override
	public String toString() {
		return this.number + ", " + this.roadName + " " + this.roadType + ", " + this.district;
	}

	@Override
	public Precision getPrecision() {
		return Precision.ADDRESS;
	}
}