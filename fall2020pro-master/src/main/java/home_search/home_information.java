package home_search;
import java.util.logging.*;

public class home_information {
	int id ;
	String type;
	String placement;
	int price;
	int area;
	boolean lessAreaYes;
	boolean betweenAreaYes;
	boolean lessPriceYes;
	boolean betweenPriceYes;
	String material;
	int numberOfBedroom;
	int numberOfBathroom1;
	boolean allowingPets1 ; 
	int leaseLength1;
	String[]amenities;
	StringBuilder build;
	  public static final Logger LOGGER = Logger.getLogger(home_information.class.getName());
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getNumberOfBedrooms() {
		return numberOfBedroom;
	}
	public void setNumberOfBedrooms(int numberOfBedroom) {
		this.numberOfBedroom = numberOfBedroom;
	}
	public int getNumberOfBathrooms() {
		return numberOfBathroom1;
	}
	public void setNumberOfBathrooms(int numberOfBathroom1) {
		this.numberOfBathroom1 = numberOfBathroom1;
	}
	public boolean getAllowingPets() {
		return allowingPets1;
	}
	public void setAllowingPets(boolean allowingPets1) {
		this.allowingPets1 = allowingPets1;
	}
	public int getLeaseLength() {
		return leaseLength1;
	}
	public void setLeaseLength(int leaseLength1) {
		this.leaseLength1 = leaseLength1;
	}
	public String[] getAmenties() {
		return amenities;
	}
	public void setAmenties(String[] amenties) {
		this.amenities = amenties;
	}
	
	public void printHomeInfo () {
		String s="Home[id="+this.getId()+ " ,type:" +this.getType() + " ,Material:" + this.getMaterial() + " ,Placement:" + this.getPlacement()+"  ,price:"+this.getPrice()+" ,area:"+this.getArea()+" ,number of bathrooms"+ this.getNumberOfBathrooms()+",number of bedrooms:"+this.getNumberOfBedrooms()+"  ,lease length :" +this.getLeaseLength()+"  ,allowing pets :"+this.getAllowingPets()+",amenties :";
		String f = null;
		build=new StringBuilder();
    	for(int i=0;i<this.getAmenties().length;i++)	
	    {
    		build.append(this.amenities[i]);
    		build.append("_");
    		

    		
	    }
    	f=build.toString();
    	s=s+f+"]"+"\n";
    	LOGGER.info(s);
	}
	

}

