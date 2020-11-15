package home_search;

public class ByRangeOfAreaSpec implements GeneralSpec {

	private int lowArea;
	private int highArea;

	public ByRangeOfAreaSpec(int lowArea, int highArea) {
		this.lowArea = lowArea;
		this.highArea = highArea;
	}

public boolean isSpecMatch(home_information home) {
	return (home.area <= highArea && home.area >= lowArea);

}

}
