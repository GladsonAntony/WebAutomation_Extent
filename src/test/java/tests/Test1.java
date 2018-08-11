package tests;

import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class Test1 extends PageFactoryInitializer
{	
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void testGoogle(String testCaseID,String emailID, String password) throws Exception
	{
		googleHomePage()
		.verifyPageTitle();
	}
}
