package fr.gaetch.location;

public enum RoadType {
	ALLEY,
	AVENUE,
	BACKROAD,
	BOULEVARD,
	BYWAY,
	COURT,
	CUL_DE_SAC,
	DRIVEWAY,
	EXPRESSWAY,
	FREEWAY,
	HIGHWAY,
	LANE,
	MOTORWAY,
	PARKWAY,
	ROAD,
	ROUTE,
	STREET,
	TERRACE,
	TURNPIKE;

	public String toString() {
		return super.toString().replace("_", "-").toLowerCase();
	}
}