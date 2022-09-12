package com.frameworkcompany.objectrepository;

import org.openqa.selenium.By;

public class HomePage {
	public static By linkMyaccount = By.xpath("(//a[@title='My Account '])[2]");
	public static By linkAccount = By.xpath("(//li[@class='customer-login'])[2]");
	//public static By linkLOgout = By.linkText("Logout");
	
	public static By linkLogout = By.xpath("(//a[@id='customer_logout_link'])[3]");
}
