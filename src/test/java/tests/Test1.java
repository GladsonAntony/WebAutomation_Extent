package tests;

import controllers.ExcelDataProvider;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class Test1 extends PageFactoryInitializer {
    @Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
    public void testGoogle(String testCaseID, String emailID, String password) throws Exception {
        googleHomePage()
                .verifyPageTitle();
    }
}
