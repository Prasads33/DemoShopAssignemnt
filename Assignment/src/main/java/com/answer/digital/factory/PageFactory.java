package com.answer.digital.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.answer.digital.pageObjects.*;

public class PageFactory {
  private final WebDriver driver;
  private final WebDriverWait wait;

  public BasePage basePage;
 
  private WatchPage watchPage;
  private homePage homePage;
  private mensClothing mensClothing;
  private womensClothing womensClothing;
 

  public PageFactory(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public BasePage getBasePage() {
    return (basePage == null) ? basePage = new BasePage() : basePage;
  }

  
  
  
  public WatchPage getWatchPage() {
	    return (watchPage == null)
	        ? watchPage = new WatchPage(driver, wait)
	        : watchPage;
	  }
  public homePage gethomePage() {
	    return (homePage == null)
	        ? homePage = new homePage(driver, wait)
	        : homePage;
	  }
  
  public mensClothing getmensClothing() {
	    return (mensClothing == null)
	        ? mensClothing = new mensClothing(driver, wait)
	        : mensClothing;
	  }

  public womensClothing getwomensClothing() {
	    return (womensClothing == null)
	        ? womensClothing = new womensClothing(driver, wait)
	        : womensClothing;
	  }
  
}
