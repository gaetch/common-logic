package fr.gaetch.person;

/**
 * Non-living entity regarded by law to have the status of personhood.
 * 
 * @author gaetch
 */
public abstract class JuridicalPerson extends LegalPerson {
	private String legalName;

	public JuridicalPerson(String legalName) {
		this.legalName = legalName;
	}

	@Override
	public String getName() {
		return this.legalName;
	}

	@Override
	public String toString() {
		return this.legalName;
	}
}