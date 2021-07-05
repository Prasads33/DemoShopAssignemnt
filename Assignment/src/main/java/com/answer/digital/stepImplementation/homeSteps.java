package com.answer.digital.stepImplementation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;	
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class homeSteps extends BaseSteps {
  Logger log = LogManager.getLogger(getClass());

  int quantity1,quantity2,quantity3,quantity4;
  public static int quantityCounter;
  public static Map<String, String> dataMap;

  
  
  
  @When("Application is launched then user should select product from Clothing categories per his wish quantity in the wishlist")
  public void user_enter_valid_information(DataTable dataTable) {
	    log.info("user enter valid information");

	    List<List<String>> data = dataTable.asLists();
	    
	    		for (int i=0;i<data.size();i++) {
	    	 String prodCategory =data.get(i).get(0);
	    	if (prodCategory.equalsIgnoreCase("clothing")){
	    		
	    			testContext.getPageFactory().gethomePage().SelectProdCate(prodCategory);
	    			 quantity1= Integer.parseInt(data.get(i).get(1));
	    			testContext.getPageFactory().gethomePage().SelectProd(prodCategory,quantity1);
	    			
	    	}else if (prodCategory.equalsIgnoreCase("mens-clothing")) {
	    		
	    		testContext.getPageFactory().getmensClothing().SelectProdCate(prodCategory);
   			 quantity3= Integer.parseInt(data.get(i).get(1));
   			testContext.getPageFactory().getmensClothing().SelectProd(prodCategory,quantity3);
	    		
	    	}
	    	else if(prodCategory.equalsIgnoreCase("watches")) {
	    		testContext.getPageFactory().getWatchPage().SelectProdCate(prodCategory);
    			 quantity2= Integer.parseInt(data.get(i).get(1));
    			 
    			 System.out.println("prodCategory ----!!"+prodCategory);
    			 System.out.println("quantity present---!!"+quantity2);
    			testContext.getPageFactory().getWatchPage().SelectProd(prodCategory,quantity2);
	    		
	    	}
	    	else if(prodCategory.equalsIgnoreCase("womens-clothing")) {
	    		
	    		testContext.getPageFactory().getwomensClothing().SelectProdCate(prodCategory);
   			 quantity4= Integer.parseInt(data.get(i).get(1));
   			 
   			 System.out.println("prodCategory ----!!"+prodCategory);
   			 System.out.println("quantity present---!!"+quantity4);
   			testContext.getPageFactory().getwomensClothing().SelectProd(prodCategory,quantity4);
	    	}
	    	else {
	    		System.out.println("Category is not present!!");
	    	}
	    			
	    		
	      System.out.println("--Prasad------"+data.get(i).get(0)); 
	      System.out.println("--Prasad------"+data.get(i).get(1));
	    		}
	    		 quantityCounter= quantity1+quantity2+quantity3+quantity4;	
	    System.out.println("Total quantityCounter----"+quantityCounter);
	    
  }
}
  
  
  
  

