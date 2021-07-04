package com.digital.stepImplementation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;	
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.answer.enums.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class wishListSteps extends BaseSteps {
  Logger log = LogManager.getLogger(getClass());

  public static Map<String, String> dataMap;
  public LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
  public Map<String, WebElement> XpathMap = new HashMap<String, WebElement>();

  @FindBy(xpath = "//*[@class='header-right col-md-3 hidden-xs']//div[3]")
	WebElement wishListButton;
  
  public WebElement lowPriceProduct;
  public String CartProdName;
  public String LessPrice;
  
  public String cartButton = "//button[contains(text(),'Add to cart')]";
  public String Cart = "//*[@class='heading-row row']//*[@class='cart-contents' and @title='Cart'][1]";
  
 // @FindBy(xpath = "//th[@class='product-price']/../../../tbody/tr/td[@class='product-price']/../td[@class='product-name']/a")
  public String product_name="//th[@class='product-price']/../../../tbody/tr/td[@class='product-price']/../td[@class='product-name']/a";
  public String product_price="//th[@class='product-price']/../../../tbody/tr/td[@class='product-price']/*[not(contains(@aria-hidden,'true'))]";
  
  
  @Then("Select click on wishList")
  public void wishListSelection() {
	    log.info("user enter valid information");
	    testContext.driverFactory.getDriver().findElement(By.xpath("//*[@class='header-right col-md-3 hidden-xs']//div[3]")).click();
	   // wishListButton.click();
	}
  
  @Then("Selected orders product quantities should match with wishlist table or page")
  public void wihListOrderValidation() {
	    log.info("Product has been added in wishList...");
	    int ExpectedValue= homeSteps.quantityCounter;
	    
	    List<WebElement> allProduct = testContext.driverFactory.getDriver().findElements(By.xpath(product_name));   
	    
	    // List<WebElement> allProduct = testContext.driverFactory.getDriver().findElements(By.xpath("//th[@class='product-price']/../../../tbody/tr/td[@class='product-price']/../td[@class='product-name']/a"));
	    System.out.println("allProduct--"+allProduct);
	    int ActualProductInWishlist=allProduct.size();
	    
	    System.out.println("---ActualProductInWishlist"+ActualProductInWishlist);
	    
	    System.out.println("quantityCounter from user---"+ActualProductInWishlist);
	    assertEquals("ActualProduct quantity and Wishlist quantity not matchching....!", ExpectedValue, ActualProductInWishlist);

   
	    
	    
	}	
  
//  @FindBy(xpath = "//th[@class='product-price']/../../../tbody/tr/td[@class='product-price']/../td[@class='product-name']/a")
//	WebElement pName;
//  
//  @FindBy(xpath = "//th[@class='product-price']/../../../tbody/tr/td[@class='product-price']")
//	WebElement pPrice;
  
  
  @Then("User should search for lower price product")
	public void searchLowestPriceProduct() {
		log.info("user enter valid information111");
		System.out.println("8888888888888");

		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		List<WebElement> allProduct = testContext.driverFactory.getDriver().findElements(By.xpath(product_name));
		int CountProductName = allProduct.size();
		System.out.println("allProduct--" + CountProductName);
		
		List<WebElement> unitPrice = testContext.driverFactory.getDriver().findElements(By.xpath(product_price));
		int CountunitPrice = unitPrice.size();
		System.out.println("unitPrice--" + CountunitPrice);

		assertEquals("All ProductName should have price...!!!",CountunitPrice,CountProductName);
		
		for (int i = 0; i < allProduct.size(); i++) {
			int UnitPrice = Integer.parseInt(unitPrice.get(i).getText().replaceAll("[^0-9]", ""));
			hm1.put(allProduct.get(i).getText(), UnitPrice);
			XpathMap.put(allProduct.get(i).getText(), allProduct.get(i));
		}

		System.out.println("HashMap----------" + hm1);

		
		hm1.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		System.out.println("Sorted Map   : " + sortedMap);

//		Map.Entry<String, Integer> actualValue = sortedMap.entrySet().stream().findFirst().get();
//		WebElement lowPriceProduct = XpathMap.get(actualValue.getKey());// Fetching lowest value XpathMap
//		lowPriceProduct.click();

	}
  
  
  
 
  @Then("User Should able to add the lowest price item to myCart")
 	public void AddLowestPriceProduct() {
	  
	  Map.Entry<String, Integer> actualValue = sortedMap.entrySet().stream().findFirst().get();
		lowPriceProduct = XpathMap.get(actualValue.getKey());// Fetching lowest value XpathMap
		System.out.println("LOWERPRiceProduct----"+lowPriceProduct.getText());
		
		LessPrice=lowPriceProduct.getText();
		lowPriceProduct.click();
		testContext.driverFactory.getDriver().findElement(By.xpath(cartButton)).click();
}
  
  
  

  
  @Then("User should able to verify the same product in myCart")
	public void validateSameProductInCart() {
	  
	  testContext.driverFactory.getDriver().findElement(By.xpath(Cart)).click();
	  
	  List<WebElement> allProduct = testContext.driverFactory.getDriver().findElements(By.xpath(product_name));
		for(WebElement prod: allProduct) {
			CartProdName=prod.getText();
			System.out.println("CartProdName-----"+CartProdName);
		}
		//String lowPriceProName=lowPriceProduct.getText();
		System.out.println("lowPriceProName--222---"+LessPrice);
		assertEquals("Mismatched found in cart with wishList product...", CartProdName,LessPrice);
	  
	  
}
  
}
  

  
  
  
  

