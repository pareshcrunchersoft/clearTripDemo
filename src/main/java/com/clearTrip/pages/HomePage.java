package com.clearTrip.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.clearTrip.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(id="OneWay")
	public WebElement rdbtn1;

	@FindBy(id="RoundTrip")
	public WebElement rdbtn2;
	
	@FindBy(id="MultiCity")
	public WebElement rdbtn3;
	
	@FindBy(id="FromTag")
	public WebElement txt_box_fromcity;
	
	@FindBy(id="ToTag")
	public WebElement txt_box_tocity;

	@FindBy(xpath="//ul[@id='ui-id-1']")
	public WebElement fromcityDDL;
	
	@FindBy(id="FromDate")
	public WebElement date_fromdate;
	
	@FindBy(id="ui-datepicker-div")
	public WebElement date_datepicker;
	
	@FindBy(id="Adults")
	public WebElement txt_box_selAdults;
	
	@FindBy(id="Childrens")
	public WebElement txt_box_selChildrens;
	
	@FindBy(id="Infants")
	public WebElement txt_box_selInfants;
	
	@FindBy(id="SearchBtn")
	public WebElement SearchBtn;
	
	@FindBy(xpath="//div[@class='ctDatePicker']/div[1]/div/div/span[1]")
	public WebElement datePickerMonth;
	
	@FindBy(xpath="//div[@class='ctDatePicker']/div[1]/div/div/span[2]")
	public WebElement datePickerYear;
	
	@FindBy(xpath="//div[@class='monthBlock first']/child::table/tbody/tr")
	public List<WebElement> days;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement selectOneWayTrip()
	{
		return rdbtn1;
	}
	
	public WebElement selectRoundTrip()
	{
		return rdbtn2;
	}
	
	public WebElement selectMulticityTrip()
	{
		return rdbtn3;
	}
	
	public void enterFromCity(String fromcity)
	{
		fromcity=fromcity.toUpperCase();
		txt_box_fromcity.sendKeys(fromcity);
		//   /child::*/a[contains(text(),'Pun')]
		List<WebElement> EleCities=txt_box_fromcity.findElements(By.xpath("//ul[@id='ui-id-1']/child::*/a"));
		List<String> cities= new ArrayList<String>();
		for(WebElement city:EleCities)
		{
			System.out.println(city.getText());
			cities.add(city.getText().toUpperCase());
			
		}
		
		EleCities.get(0).click();
	}
	
	public void enterToCity(String tocity)
	{
		//txt_box_tocity.sendKeys(tocity);
		tocity=tocity.toUpperCase();
		txt_box_tocity.sendKeys(tocity);
		//   /child::*/a[contains(text(),'Pun')]
		List<WebElement> EleCities=driver.findElements(By.xpath("//ul[@id='ui-id-2']/child::*/a"));
		List<String> cities= new ArrayList<String>();
		for(WebElement city:EleCities)
		{
			System.out.println(city.getText());
			cities.add(city.getText().toUpperCase());
			
		}
		
		EleCities.get(0).click();
	}
	
	public void selectDate(String date)
	{
		date_fromdate.click();
		
	}
	
	public void selectAdults(int noAdults)
	{
		Select s1=new Select(txt_box_selAdults);
		s1.selectByVisibleText(String.valueOf(noAdults));
		//txt_box_selAdults.sendKeys(Integer.toString(noAdults));
		
	}
	
	public void selectChildren(int noChildren)
	{
		Select s2=new Select(txt_box_selChildrens);
		s2.selectByVisibleText(String.valueOf(noChildren));
		//txt_box_selChildrens.sendKeys(Integer.toString(noChildren));
	}
	
	public void selectInfantss(int noInfants)
	{
		Select s3=new Select(txt_box_selInfants);
		s3.selectByVisibleText(String.valueOf(noInfants));
		//txt_box_selChildrens.sendKeys(Integer.toString(noInfants));
	}
	
	public searchResult clickSerchBtn()
	{
		SearchBtn.click();
		return new searchResult();
	}
	
	public void selectDate1(String dateval) throws ParseException
	{
		/*SimpleDateFormat format1=new SimpleDateFormat("dd/MMMM/yyyy");
		Date date=format1.parse(dateval);*/
		int flag=0;
		String date[]=dateval.split("/");
		if(datePickerMonth.getText().equals(date[1]))
		{
			//div[@class='monthBlock first']/child::table/tbody/tr
			
			/*for(WebElement trs: days)
			{
				List<WebElement> tds=trs.findElements(By.tagName("td"));
				
				for(WebElement td:tds)
				{
					WebElement day=td.findElement(By.tagName("span"));
					String day1=day.getText();
					if(day1.equals(date[0].trim()))
					{
						day.click();
						flag=1;
						break;
					}
					
				}
				
				if(flag==0)
					break;
			}*/
			
			//div[@class='monthBlock first']/child::table/tbody/tr/descendant::a
			List<WebElement> days=driver.findElements(By.xpath("//div[@class='monthBlock first']/child::table/tbody/tr/descendant::a"));
			
			for(WebElement day:days)
			{
				String day1=day.getText();
				if(day1.equals(date[0].trim()))
				{
					day.click();
					flag=1;
					break;
				}
				
			}
			
			
		}
		else
		{
			// click on next button
		}
		
	}
	
	public boolean verifyTitle()
	{
		return driver.getTitle().equals("#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.".trim());
	}
}
