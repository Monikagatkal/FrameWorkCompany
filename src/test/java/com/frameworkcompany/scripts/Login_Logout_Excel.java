package com.frameworkcompany.scripts;

import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.frameworkcompany.config.StartBrowser;
import com.frameworkcompany.reuse.CommonFunction;

public class Login_Logout_Excel extends StartBrowser{
  @Test
  public void Login_Logout_ExcelTestCase() throws Exception {
	  CommonFunction cfs = new CommonFunction();
	  Fillo f = new Fillo();
	  Connection con = f.getConnection("TestData/Data.xlsx");
	  String query = "select * from Login";
	  Recordset rs = con.executeQuery(query);
	  while(rs.next())
	  {
		  cfs.login(rs.getField("UserName"),rs.getField("Password"));
		  Thread.sleep(2000);
		  cfs.logOut();
	  }
	  
  }
}
