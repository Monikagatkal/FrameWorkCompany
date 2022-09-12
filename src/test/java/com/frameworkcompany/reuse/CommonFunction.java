package com.frameworkcompany.reuse;

import org.openqa.selenium.WebDriver;

import com.frameworkcompany.config.StartBrowser;
import com.frameworkcompany.objectrepository.HomePage;
import com.frameworkcompany.objectrepository.LoginPage;
import com.frameworkcompany.webdrivercmds.ActionDriver;

public class CommonFunction {

	 public ActionDriver aDriver;
	 public WebDriver driver;
	 
	 public CommonFunction()
	 {
		 aDriver = new ActionDriver();
		 driver = StartBrowser.driver;
	 }
	 
	 public void login() throws Exception
	 {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Application");
		aDriver.navigateToApplication("https://www.at-home.co.in/");
		aDriver.click(HomePage.linkMyaccount, "My Account Link");
		aDriver.type(LoginPage.txtEmail,"monikagatkal43@gmail.com","Email Textbox");
		Thread.sleep(2000);
		aDriver.type(LoginPage.txtPassword, "Monika@12345", "Password Textbox");
		Thread.sleep(2000);
		aDriver.click(LoginPage.btnSubmit, "Button Submit");
	 }
	 
	 public void login(String userName, String passWord) throws Exception
	 {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Application");
		aDriver.navigateToApplication("https://www.at-home.co.in/");
		aDriver.click(HomePage.linkMyaccount, "My Account Link");
		aDriver.type(LoginPage.txtEmail,userName,"Email Textbox");
		Thread.sleep(2000);
		aDriver.type(LoginPage.txtPassword, passWord, "Password Textbox");
		Thread.sleep(2000);
		aDriver.click(LoginPage.btnSubmit, "Button Submit");
	 }
	 
	 public void logOut() throws Exception 
	 {
		 StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout from Application");
		 aDriver.mouseHover(HomePage.linkAccount, "Account Link");
		 aDriver.click(HomePage.linkLogout, "Logout Link");
	 }
}
