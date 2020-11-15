package home_search;

public class ByAmenitySpec implements GeneralSpec {

	private String amenity;

	public ByAmenitySpec(String amenity) {
		this.amenity = amenity;
		
	}

	public boolean isSpecMatch(home_information home) {
		boolean flag = false;
		for (String am : home.amenities) {
			if (amenity.equalsIgnoreCase(am)) {
				 flag = true;
				break;
			}

		}
		return flag;
	}
	

}
