package com.clearTrip.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.clearTrip.base.TestBase;
import com.clearTrip.pages.HomePage;
import com.clearTrip.pages.searchResult;

import org.testng.annotations.BeforeClass;

import java.text.ParseException;

import org.testng.annotations.AfterClass;

public class testHomePage extends TestBase{
	
	HomePage homepage;
	SoftAssert sa;
	
  public  testHomePage() {
	// TODO Auto-generated constructor stub
	  
	  super();
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  init();
	  homepage=new HomePage();
	  
  }

  @AfterClass
  public void afterClass() {
	 // driver.quit();
  }

  @Test(enabled=false)
  public void verifyTitle()
  {
	  sa.assertTrue(homepage.verifyTitle());
  }
  
  @Test
  public void flightBook() throws ParseException {
	  
	  homepage.selectOneWayTrip().click();
	  homepage.enterFromCity("Pune");
	  homepage.enterToCity("Mum");
	  homepage.selectDate1("23/July/2019");
	  homepage.selectAdults(3);
	  homepage.selectChildren(1);
	  homepage.selectInfantss(1);
	  searchResult searchresult= homepage.clickSerchBtn();
	  //sa.assertEquals(actual, expected);
  }
  

}
