package home_search;

public class ByPriceBelowSpec implements GeneralSpec {

	private int price;

	public ByPriceBelowSpec(int price) {
		this.price = price;
		
	}

	public boolean isSpecMatch(home_information home) {
		return home.price<=this.price;

	}
}
