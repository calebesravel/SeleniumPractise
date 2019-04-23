package com.selbot.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class Erailpage extends Annotations {
	public Erailpage() {
		PageFactory.initElements(driver, this);
		}
	@FindBy(how = How.ID, using = "txtStationFrom")
	WebElement elestationfrom;
	@FindBy(how = How.ID, using = "txtStationTo")
	WebElement elestationto;
	@FindBy(how = How.ID, using = "chkSelectDateOnly")
	WebElement elecheckboxverfication;
	@FindBy(how = How.XPATH, using = "//table[@class='DataTable TrainList']")
	WebElement elefindtable;
	@FindBy(how = How.XPATH, using = "//a[text()='SHATABDI EXP']")
	WebElement eleclickshatabiexp;
	@FindBy(how = How.XPATH, using = "//table[@class='DataTable Rake']")
	WebElement eleavailableseats;
	
	
	
	public Erailpage Enterstationfrom() {
		elestationfrom.clear();
		elestationfrom.sendKeys("MAS",Keys.TAB);
		return this;
	}
		public Erailpage Enterstationto() {
			elestationto.clear();
			elestationto.sendKeys("SBC",Keys.TAB);
			return this;
		}
		public Erailpage Checkboxverification() throws InterruptedException {
			WebElement checkBox = elecheckboxverfication;
			if (checkBox.isSelected()) {
				elecheckboxverfication.click();
			}
			Thread.sleep(2000);
			return this;
		}
		public Erailpage Findtable() {
			WebElement table = elefindtable;
			//go to rows
			List<WebElement> rows = table.findElements(By.tagName("tr")); 
			System.out.println("Row Count: "+rows.size()); 
			
			for (int i = 0; i < rows.size(); i++) {
				WebElement eachRow = rows.get(i);
				//go to columns
				List<WebElement> columns = eachRow.findElements(By.tagName("td"));
				//System.out.println("Column Count: " + columns.size());
				System.out.println(columns.get(1).getText());
			}
			return this;
		}
		public Erailpage availableseats() {
			eleclickshatabiexp.click();
			WebElement available = eleavailableseats;
			//go to row
			List<WebElement> row = available.findElements(By.tagName("tr"));
			 List<String> availableList = new ArrayList<>();
			 availableList.add(row.get(2).getText());
			 System.out.println(availableList);         
			return this;
		}
}
