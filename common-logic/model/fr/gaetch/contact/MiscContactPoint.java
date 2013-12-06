package fr.gaetch.contact;

public class MiscContactPoint implements Contact {
	private String name;

	public MiscContactPoint(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
}