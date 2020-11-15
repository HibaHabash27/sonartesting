package home_search;

public class ByTypeSpec implements GeneralSpec {

	private String type;

	public ByTypeSpec(String type) {
		this.type = type;
		
	}
	
	public boolean isSpecMatch(home_information home) {
		return home.type.equalsIgnoreCase(this.type);
	}

}
