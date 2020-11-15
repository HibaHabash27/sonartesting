package home_search;

public class ByPlaceSpec implements GeneralSpec {

	private String place;

	public ByPlaceSpec(String place) {
		this.place = place;
		
	}

public boolean isSpecMatch(home_information home) {
	return home.placement.equalsIgnoreCase(this.place);

}

}
