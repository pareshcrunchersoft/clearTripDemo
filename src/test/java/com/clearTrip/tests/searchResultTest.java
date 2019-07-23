package com.clearTrip.tests;

import org.testng.annotations.Test;

import com.clearTrip.base.TestBase;
import com.clearTrip.pages.searchResult;

import org.testng.annotations.BeforeClass;



import org.testng.annotations.AfterClass;

public class searchResultTest extends TestBase {
	
	searchResult searchresult;
	public searchResultTest()
	{
		super();
	}
	
	
  @Test
  public void f() {
	  searchresult.bookAFlight();
  }
  @BeforeClass
  public void beforeClass() {
	  init();
	  searchresult= new searchResult();
	 
  }

  @AfterClass
  public void afterClass() {
  }

}
