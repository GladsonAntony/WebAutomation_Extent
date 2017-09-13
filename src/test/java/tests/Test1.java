package tests;

import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class Test1 extends PageFactoryInitializer
{	
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void testGoogle(String testCaseID,String emailID, String password) throws Exception
	{
		System.out.println("TestCase ID: "+testCaseID);
		System.out.println("EmailID "+emailID);
		System.out.println("Password: "+password);
	}
}
