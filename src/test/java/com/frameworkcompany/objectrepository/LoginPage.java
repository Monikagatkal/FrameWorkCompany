package com.frameworkcompany.objectrepository;

import org.openqa.selenium.By;

public class LoginPage {
	public static By txtEmail = By.id("customer_email");
	public static By txtPassword = By.id("customer_password");
	public static By btnSubmit = By.xpath("(//input[@class='btn action_button'])[1]");

}
