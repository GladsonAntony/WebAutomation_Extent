/**
 * 
 */
package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.FluentWaiting;
import utils.RandomGenerator;

/**
 * @author ${Gladson Antony}
 * @date Sep 17, 2016
 * 
 */
public class GoogleHomePageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//a[text()='Gmail']")
	private WebElement GmailLink;

	@FindBy(id="lst-ib")
	private WebElement SearchBox;

	
	public GoogleHomePageObjects clickonGmailLink() throws Exception
	{
		FluentWaiting.waitUntillElementToBeClickable(5, 500, GmailLink);
		click(GmailLink);
		return this;		
	}


	public GoogleHomePageObjects enterTextToSearchBox() 
	{
		SearchBox.sendKeys(RandomGenerator.GenerateRandomEMAILIDs("google.com"));
		return this;	
	}

	
	public GoogleHomePageObjects verifyPageTitle() throws Exception 
	{
		FluentWaiting.waitForTitleToBe(5, 500, "Google");
		return this;
	}

}
