package pageObjects.initializePageObjects;

import controllers.BaseMethod;
import org.openqa.selenium.support.PageFactory;
import pageObjects.modules.GMailPageObjects;
import pageObjects.modules.GoogleHomePageObjects;

/**
 * @author ${Gladson Antony}
 * @date Sep 17, 2016
 */

public class PageFactoryInitializer extends BaseMethod {
    public GoogleHomePageObjects googleHomePage() {
        return PageFactory.initElements(getWebDriver(), GoogleHomePageObjects.class);
    }

    public GMailPageObjects gmailPage() {
        return PageFactory.initElements(getWebDriver(), GMailPageObjects.class);
    }
}
