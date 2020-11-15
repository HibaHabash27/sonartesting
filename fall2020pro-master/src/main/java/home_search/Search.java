package home_search;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Search {
   private static WebEmailservice mailservice;
	List<home_information> homeResult;
	boolean flag;
	GeneralSpec spec;
	 List<home_information> homeArray1;
	home_information home;
	String emailAddress="hayasam@najah.edu";

	public static final Logger LOGGER = Logger.getLogger(Search.class.getName());
	public Search(ArrayList<home_information> homeArray) {
		homeArray1=new ArrayList<home_information>(homeArray);
		homeResult=new ArrayList<home_information>();
		
		/*for(int i=0;i<homeArray.size();i++)
		{
			homeArray1.add(homeArray.get(i));
			
			
		}*/
	

	}
	public static void setemail(WebEmailservice webemail1) {
		
		mailservice=webemail1;
		}


	


	public ArrayList<home_information> byType(String type) {
		 spec = new ByTypeSpec (type);
		
		 
		 mailservice.sendMail(emailAddress, checkSpec(spec));
		return checkSpec(spec);
	}


	public ArrayList<home_information> byPlacement(String place) {
		
		spec = new ByPlaceSpec (place);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
		
	}
	

	
	public ArrayList<home_information> printResult() {
		

		if (homeResult.isEmpty()) {
			LOGGER.info("There is no house with such specifications :( ");	
		}
		else
		{	
		for (home_information home2 : homeResult) {
			home2.printHomeInfo();
			
		}
		}
		
		return (ArrayList<home_information>) homeResult;
	}

	
	
	
	public ArrayList<home_information> byPrice(int price) {
		
	 spec = new ByPriceBelowSpec (price);
	 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}
	
	
	
	

	public  ArrayList<home_information> byMaterial(String material) {
		 spec = new ByMaterialSpec (material);
		mailservice.sendMail(emailAddress,checkSpec(spec));

		return checkSpec(spec);

	}

	public ArrayList<home_information> byNumberOfBedrooms(int numberOfBedrooms) {
		 spec = new ByNumberOfBedroomsSpec (numberOfBedrooms);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}

	public ArrayList<home_information> byNumberOfBathrooms(int numberOfBathrooms) {
		
		 spec = new ByNumberOfBathroomsSpec ( numberOfBathrooms);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}

	public ArrayList<home_information> betweenRangeOfPrice(int lowPrice, int highPrice) {
		
		 spec = new ByRangeOfPriceSpec ( lowPrice,highPrice);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}

	public ArrayList<home_information> betweenRangeOfarea(int lowArea, int highArea) {
		
		
		 spec = new ByRangeOfAreaSpec ( lowArea,highArea);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}

	public  ArrayList<home_information> byAreaBelow(int area1) {
		 
		 spec = new ByAreaBelowSpec ( area1);
		
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}



	public  ArrayList<home_information>  byAllowingPets(boolean pets) {
		
		 spec = new ByAllowingPetsSpec ( pets);
	 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);

	}


	public  ArrayList<home_information> byLeaseLength(int leaseLength) {
		
		 spec = new ByLeaseLengthSpec ( leaseLength);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		
		
		return checkSpec(spec);

	}

	public ArrayList<home_information> byAmenities(String amenity) {
		
		 spec = new ByAmenitySpec ( amenity);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);

	}

	public  void bycombination(ArrayList<home_information> a) {
		
		

		 mailservice.sendMail(emailAddress, a);

		
		
		

	}


	public ArrayList<home_information> checkSpec(GeneralSpec spec) {
		
		
		for(home_information a:homeArray1 )
			{
			 
			if (spec.isSpecMatch(a))
				homeResult.add(a);
		}
		return (ArrayList<home_information>) homeResult;
	}

}