package com.digital.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.digital.stepImplementation.BaseSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class homePage extends BaseSteps {
  Logger log = LogManager.getLogger(getClass());
  final String xPath1= "//*[@class='header-search-select']";
  final String blankArea1= "//*[@id='blog']/a";
  final String bikiniProd1= "//*[@data-product-id='22']";
  final String womenDress1="//*[@data-product-id='24']";
  final String hardTop= "//*[@data-product-id='18']";
  final String BlackTrouser= "//*[@data-product-id='15']";
  
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Actions actions;
  String validateLandedWebPageURL;
  public homePage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    this.actions = new Actions(driver);
    PageFactory.initElements(driver, this);
  }
  
 
  @FindBy(xpath = xPath1)
	WebElement allCategory;
  
  @FindBy(xpath = blankArea1)
 	WebElement blankArea;
  
  @FindBy(xpath = "//*[@id='blog']/div[2]/div[1]/div/div/div[2]/div[1]/form/button")
	WebElement submitButton;
  
  @FindBy(xpath = womenDress1)
	String womenDress;
  
  
  @FindBy(xpath = bikiniProd1)
 	WebElement BikiniProd;
  

public void SelectProdCate(String prodCategory) {
	
	boolean URLMatch=false;
	
	allCategory.click();
	
	System.out.println("----allCategory---"+prodCategory);
	
	Select dropdown = new Select(driver.findElement(By.xpath(xPath1)));
	dropdown.selectByValue(prodCategory);
	submitButton.click();
	URLMatch=ValidateLandedPageURL(prodCategory);
	Assert.assertTrue("MatchFound!", URLMatch);
	
	 

}
public boolean ValidateLandedPageURL(String prodCategory) {
	boolean URLMatch=false;
	try {
	 String validateLandedWebPageURL = testContext.driverFactory.getDriver().getCurrentUrl();
     
	    System.out.println("URLtitle--"+validateLandedWebPageURL);
	    if(validateLandedWebPageURL.contains(prodCategory)) {
	    	URLMatch=true;
	    }
		System.out.println("URLMatch--"+URLMatch);
	  	}
	catch(Exception e){
		System.out.println(e);
	}
	return URLMatch;
	
}


public void SelectProd (String prodCate, int quantity)  {
   List<String> l1 = getXPathList();

	for (int j=0;j<quantity;j++) {
		
		testContext.driverFactory.getDriver().findElement(By.xpath(l1.get(j))).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String productAdded= testContext.driverFactory.getDriver().findElement(By.xpath(l1.get(j))).getText();
		System.out.println("productAdded--"+productAdded);
		 assertEquals(
			        "Invalid Page Title",
			        "Product added! Browse wishlist",
			        testContext.driverFactory.getDriver().findElement(By.xpath(l1.get(j))).getText());
			  
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

List<String> getXPathList() {
	List<String> l1= new ArrayList<String>();
	l1.add(bikiniProd1);
	l1.add(hardTop);
	l1.add(womenDress1);
	l1.add("BlackTrouser");
	return l1;
}




































  
  
  
}