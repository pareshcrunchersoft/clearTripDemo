package com.clearTrip.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clearTrip.base.TestBase;

public class searchResult extends TestBase{
	
	@FindBy(xpath="//li[@class='listItem  nonBundled  ']")
	public static List<WebElement> flightDetails;
	
	@FindBy(className="depart")
	public static WebElement deptTime;

	
	@FindBy(className="arrive")
	public static WebElement arriveTime;
	
	
	@FindBy(className="duration")
	public static WebElement duration;
	
	
	@FindBy(className="price")
	public static WebElement price;
	
	
	
	@FindBy(className="booking")
	public static WebElement bookingBtn;
	
	
	public Map<Integer,Object[]> flightDetailsMap;
	
	public searchResult()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void bookAFlight()
	{
		flightDetailsMap=new HashMap();
		Integer i=new Integer("0");
		
		for(WebElement row:flightDetails)
		{
			WebElement deptTimeEle=row.findElement(By.className("depart"));
			WebElement arriveTimeEle=row.findElement(By.className("arrive"));
			WebElement durationEle=row.findElement(By.className("duration"));
			WebElement priceEle=row.findElement(By.className("price"));
		
			Object o[]= new Object[]{
			   deptTimeEle.getText(), 
			   arriveTimeEle.getText(),
			   durationEle.getText(),
			   priceEle.getText()};
			
			//Object o=new Object (deptTimeEle.getText(),arriveTimeEle.getText(),durationEle.getText(),priceEle.getText());
			 flightDetailsMap.put(i, o);
			
			System.err.println(deptTimeEle.getText()+" "+arriveTimeEle.getText()+" "+priceEle.getText());
			
		}
	}
	
	public void checkFlightTimeDuration()
	{
		
	}
}
