package com.selbot.testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.pages.Erailpage;
import com.selbot.pages.LoginPage;
import com.selbot.testng.api.base.Annotations;
public class TC101_Erail extends Annotations {
	
	@Test(dataProvider = "fetchData")
	public void logIn() throws InterruptedException {		
		new Erailpage()
		.Enterstationfrom()
		.Enterstationto()
		.Findtable()
		.availableseats();
	}


}
