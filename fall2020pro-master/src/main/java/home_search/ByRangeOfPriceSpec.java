package home_search;

public class ByRangeOfPriceSpec implements GeneralSpec {

	private int lowPrice;
	private int highPrice;

	public ByRangeOfPriceSpec(int lowPrice, int highPrice) {
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		
	}



	public boolean isSpecMatch(home_information home) {
		return (home.price <= highPrice && home.price >= lowPrice);

	}

}
