package home_search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.ArrayList;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.mockito.Mockito.*;
import org.picocontainer.*;
public class search_home {
	List<home_information> home_inf = new ArrayList<home_information>();
	private MockEmailHolder mockHolder;
	private WebEmailservice mailservice;
	String type;
	int price_less;
	int arealess;
	String placement;
	String material;
	String amenities;
	int numberOfBedroom2, leaseLen;
	int numberOfBathroom2;
	int lowPrice2, highPrice2, homeArea2, lowArea2, highArea2;
	boolean pets;
	String leaseLength;
	List<List<String>> list;
    private static Search  search;
	private  MultiSpecHandler multiSpecHandler;
	public ArrayList<GeneralSpec> specList = new ArrayList<GeneralSpec>();


	
	public search_home (Search search, MockEmailHolder mockHolder1) 
   {
 	this.search=search;
  	mockHolder=mockHolder1;
   }
   

   
	@Given("these homes are contained in the system")
	public void theseHomesAreContainedInTheSystem(io.cucumber.datatable.DataTable dataTable) {
		
      
		list = dataTable.asLists();
		for (int i = 0; i < list.size(); i++) {
			
			List<String> list2 = list.get(i);
			String ss = list2.get(0);
			String s2 = list2.get(1);
			String[] tokens = ss.split("_");
			String[] tokens2 = s2.split("_");
			home_information home = new home_information();
			home.setId(i+1);
			home.setType(tokens[0]);
			home.setMaterial(tokens[1]);
			home.setPlacement(tokens[2]);
			if (tokens[3].equalsIgnoreCase("yes"))
				home.setAllowingPets(true);
			
			else
				home.setAllowingPets(false);
			String[] am = tokens[4].split(",");
			home.setAmenties(am);
			home.setPrice(Integer.parseInt(tokens2[0]));
			home.setArea(Integer.parseInt(tokens2[1]));
			home.setNumberOfBathrooms(Integer.parseInt(tokens2[3]));
			home.setNumberOfBedrooms(Integer.parseInt(tokens2[2]));
			home.setLeaseLength(Integer.parseInt(tokens2[4]));
			
			
			home_inf.add(home);
			
			

		}
		 search = new Search((ArrayList<home_information>) home_inf);

	}
	 List<home_information> check = new ArrayList<home_information>();
	 

	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String string) {
		type=string;
		
	}

	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by type: "+type);
		check.clear();
		check.addAll(search.byType(type));
		for(home_information homeCheck:check)
		{
			assertEquals(homeCheck.type, type);
			
		}

		search.printResult();
		

	}

	@Then("email with result should be send to user {string}")
	public void emailWithResultShouldBeSendToUser(String string) {
			
		verify(mockHolder.getEmail(),times(1)).sendMail(string, check);
		
		}




	@When("I search about home with price less than {int}")
	public void iSearchAboutHomeWithPriceLessThan(Integer int1) {
       price_less=int1;
		check.clear();
		check=search.byPrice(int1);
		for(home_information homeCheck:check)
		{
			assertTrue(homeCheck.price<int1);
			
		}
	}

	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by price less than "+price_less);
		search.printResult();
	}
	
		@Then("email with result should be send to user1 {string}")
		public void emailWithResultShouldBeSendToUser1(String string) {
    	verify(mockHolder.getEmail(),times(1)).sendMail(string, check);
		
		}




	@When("i search about home by_placement {string}")
	public void iSearchAboutHomeByPlacement(String string) {
		placement=string;
		check.clear();
		check=search.byPlacement(string);
		for(home_information homeCheck:check)
		{
			assertEquals(homeCheck.placement, placement);
			
		}
	}

	@Then("A list of homes that matches the  placement specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePlacementSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by placement :"+ placement);
        search.printResult();
	}
	

		@Then("email with result of placement should be send to user1 {string}")
		public void emailWithResultOfPlacementShouldBeSendToUser1(String string) {
			verify(mockHolder.getEmail(),times(1)).sendMail(string, check);
		}




	@When("I search about home by_material {string}")
	public void iSearchAboutHomeByMaterial(String string) {
		material=string;
		check.clear();
		check=search.byMaterial(string);
		for(home_information homeCheck:check)
		{
			assertEquals(homeCheck.material, material);
			
		}
	}

	@Then("A list of homes that matches the  material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by material :" +material);
		search.printResult();
	}

		@Then("email with result of material should be send to user1 {string}")
		public void emailWithResultOfMaterialShouldBeSendToUser1(String string) {
			verify(mockHolder.getEmail(),times(1)).sendMail(string, check);
		}




	
		@When("I search about home by_number_of_bedroom {string}")
		public void iSearchAboutHomeByNumberOfBedroom(String string) {
			numberOfBedroom2 = Integer.parseInt(string);
			check.clear();
			check=search.byNumberOfBedrooms(numberOfBedroom2);
			for(home_information homeCheck:check)
			{
				assertEquals(homeCheck.numberOfBedroom,numberOfBedroom2);
				
			}
			
		}



		@Then("A list of homes that matches the  number_of_bedroom specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheNumberOfBedroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			System.out.println("Search by number of bedrooms :" +numberOfBedroom2);
			search.printResult();
		}
		

			@Then("email with result of numberOfBedroom should be send to user1 {string}")
			public void emailWithResultOfNumberOfBedroomShouldBeSendToUser1(String string) {
				verify(mockHolder.getEmail(),times(1)).sendMail(string, check);

			}





		@When("I search about home by_number_of_bathroom {string}")
		public void iSearchAboutHomeByNumberOfBathroom(String string) {
			numberOfBathroom2 = Integer.parseInt(string);
			
		}


	
		@Then("A list of homes that matches the  number_of_bathroom specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheNumberOfBathroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			System.out.println("Search by number of bathrooms :" +numberOfBathroom2);
			check.clear();
			check=search.byNumberOfBathrooms(numberOfBathroom2);
			for(home_information homeCheck:check)
			{
				assertEquals(homeCheck.numberOfBathroom1,numberOfBathroom2);
				
			}
			search.printResult();
		}
		

			@Then("email with result of numberOfBathroom should be send to user1 {string}")
			public void emailWithResultOfNumberOfBathroomShouldBeSendToUser1(String string) {
				verify(mockHolder.getEmail(),times(1)).sendMail(string, check);

			}




	@When("I search about home between {int} and {int}")
	public void iSearchAboutHomeBetweenAnd(Integer int1, Integer int2) {
		lowPrice2 = int1;
		highPrice2 = int2;
		search.betweenRangeOfPrice(lowPrice2, highPrice2);

	}

	@Then("A list of homes that matches the  range of price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangeOfPriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by price between "+ lowPrice2 +","+ highPrice2);
		check.clear();
		check=search.betweenRangeOfPrice(lowPrice2, highPrice2);
		for(home_information homeCheck:check)
		{
			assertTrue(homeCheck.price>lowPrice2 && homeCheck.price<highPrice2);
			
		}
		search.printResult();
	}
	

		@Then("email with result of rangeOfPrices should be send to user1 {string}")
		public void emailWithResultOfRangeOfPricesShouldBeSendToUser1(String string) {
			verify(mockHolder.getEmail(),times(2)).sendMail(string, check);

		}




	@When("I search home below area {int}")
	public void iSearchHomeBelowArea(Integer int1) {
		arealess=int1;
	
	}

	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by area less than "+arealess);
		check.clear();
		check=search.byAreaBelow(arealess);
		for(home_information homeCheck:check)
		{
			assertTrue(homeCheck.area<arealess);
			
		}
		search.printResult();
	}

		@Then("email with result of belowArea should be send to user1 {string}")
		public void emailWithResultOfBelowAreaShouldBeSendToUser1(String string) {
			verify(mockHolder.getEmail(),times(1)).sendMail(string, check);

		}




	@When("I search about home by_Alolowing pets {string}")
	public void iSearchAboutHomeByAlolowingPets(String string) {
		if (string.equalsIgnoreCase("yes"))
			pets = true;
		else
			pets = false;
		
	}

	@Then("A list of homes that matches the  Allowing pets specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAllowingPetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by allowing pets");

		check.clear();
        check=search.byAllowingPets(pets);
        for(home_information homeCheck:check)
		{
			assertEquals(homeCheck.allowingPets1,pets);
			
		}

		search.printResult();

	}
	
		@Then("email with result of allowingPets should be send to user1 {string}")
		public void emailWithResultOfAllowingPetsShouldBeSendToUser1(String string) {
			verify(mockHolder.getEmail(),times(1)).sendMail(string, check);

		}




	@When("I search about home area between {int} and {int}")
	public void iSearchAboutHomeAreaBetweenAnd(Integer int1, Integer int2) {
		lowArea2 = int1;
		highArea2 = int2;

	}

	@Then("A list of homes that matches the  range of area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangeOfAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by area between "+lowArea2+" , "+highArea2);
		check.clear();
		check=search.betweenRangeOfarea(lowArea2, highArea2);
		assertEquals(0,check.size());
		search.printResult();

	}
	
		@Then("email with result of areaRange should be send to user1 {string}")
		public void emailWithResultOfAreaRangeShouldBeSendToUser1(String string) {
			verify(mockHolder.getEmail(),times(1)).sendMail(string, check);

		}




	@When("I search about home by lease length {string}")
	public void iSearchAboutHomeByLeaseLength(String string) {
		leaseLength=string;
		if (string.equalsIgnoreCase("short"))
			leaseLen = 6;
		else
			leaseLen = 12;

	}

	@Then("A list of homes that matches the  lease length specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheLeaseLengthSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by lease length :" +leaseLength);
		check.clear();
		check=search.byLeaseLength(leaseLen);
		for(home_information homeCheck:check)
		{
			assertEquals(leaseLen,homeCheck.leaseLength1);
			
		}
		search.printResult();
	}

		@Then("email with result of leaseLength should be send to user1 {string}")
		public void emailWithResultOfLeaseLengthShouldBeSendToUser1(String string) {
			verify(mockHolder.getEmail(),times(1)).sendMail(string, check);

		}



	@When("I search about home by Amenities {string}")
	public void iSearchAboutHomeByAmenities(String string) {
		amenities = string;
		search.byAmenities(amenities);

	}

	@Then("A list of homes that matches the  Amenities specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAmenitiesSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by amenities :"+ amenities);
		check.clear();
		check=search.byAmenities(amenities);
		for(home_information homeCheck:check)
		{
			for(String s:homeCheck.amenities)
				if(amenities.equalsIgnoreCase(s))
		      	assertEquals(amenities, s);
			
		}
		search.printResult();

	}
	

		@Then("email with result of amenities should be send to user1 {string}")
		public void emailWithResultOfAmenitiesShouldBeSendToUser1(String string) {
			verify(mockHolder.getEmail(),times(2)).sendMail(string, check);

		}




			@When("I search about home area13 between {int} and {int}")
			public void iSearchAboutHomeArea13BetweenAnd(Integer int1, Integer int2) {
				lowArea2 = int1;
				highArea2 = int2;
				
				GeneralSpec spec = new ByRangeOfAreaSpec(lowArea2,highArea2);
				specList.add(spec);
				
			
				
				
				
				
			  
			}
			
				@When("I search about home by_material13 {string}")
				public void iSearchAboutHomeByMaterial13(String string) {
				    material=string;
				    GeneralSpec spec = new ByMaterialSpec(material);
				    specList.add(spec);
				    
				   


				}
				

					@When("I search about home by placement13 {string}")
					public void iSearchAboutHomeByPlacement13(String string) {
						placement=string;
						GeneralSpec spec = new ByPlaceSpec(placement);
					    specList.add(spec);
					}
					
					Boolean allowingPets;
						@When("I search about home by Allowing_pets {string}")
						public void iSearchAboutHomeByAllowingPets(String string) {
							
							if(string.equalsIgnoreCase("YES"))
								allowingPets=true;
							allowingPets=false;
							GeneralSpec spec = new ByAllowingPetsSpec(allowingPets);
						    specList.add(spec);
							
						}




		@Then("A list of homes that matches the previous specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesThePreviousSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			System.out.println("Search more than one attribute");
			
			multiSpecHandler= new MultiSpecHandler(specList,home_inf);
		    check=multiSpecHandler.result();
			assertEquals(1,check.size());
			for(home_information homeCheck:check)
			{
				assertTrue(homeCheck.area <= highArea2 && homeCheck.area >= lowArea2);
				
				assertEquals(placement,homeCheck.placement);
				assertEquals(material, homeCheck.material);
				assertEquals(allowingPets, homeCheck.allowingPets1);
				
				
			}

			multiSpecHandler.print();

		}
		
		
		
		

			@Then("A list of homes that matches the previous specification of test two should be returned and printed on the console")
			public void aListOfHomesThatMatchesThePreviousSpecificationOfTestTwoShouldBeReturnedAndPrintedOnTheConsole() {
				System.out.println("Search more than one attribute");
				
				multiSpecHandler= new MultiSpecHandler(specList,home_inf);
			    check=multiSpecHandler.result();
				assertEquals(0,check.size());
				multiSpecHandler.print();
			}



		
		
		
		
			@Then("email with result of Combination should be send to user1 {string}")
			public void emailWithResultOfCombinationShouldBeSendToUser1(String string) {
				verify(mockHolder.getEmail(),times(1)).sendMail(string, check);

			}







}





