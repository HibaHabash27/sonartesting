package home_search;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MultiSpecHandler {
     List<GeneralSpec> specList;
     Search search;
    ArrayList<home_information> resultArrayList;
	private List<home_information> homeArray;
	boolean firstSpec = true;
	 public static final Logger LOGGER = Logger.getLogger(MultiSpecHandler.class.getName());
	public MultiSpecHandler(List<GeneralSpec> specList , List<home_information> homeArray) {
		super();
		this.specList = new ArrayList<GeneralSpec>(specList);
		this.homeArray= new ArrayList<home_information>(homeArray);
		
		
	}

	

	public ArrayList<home_information> result(){
		
		
		for (GeneralSpec spec : specList) {
			
			if (firstSpec) {
			for (int i=0;i<homeArray.size();i++) {
				search= new Search ((ArrayList<home_information>) homeArray);
				resultArrayList=search.checkSpec(spec);
			
			} firstSpec=false;}
			else 
			{
				for (int j=0;j<resultArrayList.size();j++) {
			     search= new Search(resultArrayList);
			     resultArrayList=search.checkSpec(spec);
						
			}
			}
		}
		
		
		
		search.bycombination(resultArrayList);
		return resultArrayList;
	}




	public void print() {
		if (resultArrayList.isEmpty()) {
			LOGGER.info("There is no house with such specifications :( ");	
		}
		else
		{	
		for (home_information home : resultArrayList) {
			home.printHomeInfo();
			
		}
		}
		
	} 
	
	
	
	
	
	
}
