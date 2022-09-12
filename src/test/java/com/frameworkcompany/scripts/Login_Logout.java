package com.frameworkcompany.scripts;

import org.testng.annotations.Test;

import com.frameworkcompany.config.StartBrowser;
import com.frameworkcompany.reuse.CommonFunction;

public class Login_Logout extends StartBrowser{
	
  @Test
  public void Login_LogoutTestCase() throws Exception {
	  CommonFunction cfs = new CommonFunction();
	  cfs.login();
	  Thread.sleep(2000);
	  cfs.logOut();
	  Thread.sleep(2000);
  }
}
