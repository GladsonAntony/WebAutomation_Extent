/**
 * @Author Gladson Antony
 * @Date 10-Sep-2017 
 * @Time 11:06:48 AM
 */
package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controllers.BaseMethod;

public class ExplicitWaiting extends BaseMethod {
	public static WebDriver driver;
	
	/*Select using WebElements*/
	/** To Wait Until Element to be Clickable */	
	public static void explicitWaitElementToBeClickable(WebElement element, int time) 
	{
		WebDriverWait clickableWait = new WebDriverWait(driver, time);
		clickableWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/** To Wait Until Element to be Selectable */
	public static void explicitWaitElementToBeSelected(WebElement element, int time) {
		WebDriverWait selectableWait = new WebDriverWait(driver, time);
		selectableWait.until(ExpectedConditions.elementToBeSelected(element));
	}
	

	/** To Wait Until Element has the text */
	public static void explicitWaitTextToBePresentInElement(WebElement element, int time, String text) {
		WebDriverWait textToBePresent = new WebDriverWait(driver, time);
		textToBePresent.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	
	/** To Wait Until Title contains the text */
	public static void explicitWaitTitleContains(WebElement element, int time, String title) {
		WebDriverWait titleContains = new WebDriverWait(driver, time);
		titleContains.until(ExpectedConditions.titleContains(title));
	}
	
	
	/** To Wait Until Title is */
	public static void explicitWaitTitleIs(WebElement element, int time, String title) {
		WebDriverWait titleIs = new WebDriverWait(driver, time);
		titleIs.until(ExpectedConditions.titleIs(title));
	}
	
	
	/** To Wait Until Element to be Visible */
	public static void explicitWaitVisibilityOfElement(WebElement element, int time) {
		WebDriverWait elementToBeVisible = new WebDriverWait(driver, time);
		elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/** To Wait Until Element is Selected */
	public static void explicitWaitSelectionStateToBe(WebElement element, int time, boolean selected) {
		WebDriverWait elementIsSelected = new WebDriverWait(driver, time);
		elementIsSelected.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}
	
	
	/** To Wait Until Elements to be Visible */
	public static void explicitWaitVisibilityOfElements(List<WebElement> element, int time) {
		WebDriverWait elementsToBeVisible = new WebDriverWait(driver, time);
		elementsToBeVisible.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	
	/*Select using By Method*/
	/** To Wait Until Element to be Clickable */	
	public static void explicitWaitElementToBeClickable(By element, int time) {
		WebDriverWait clickableWait = new WebDriverWait(driver, time);
		clickableWait.until(ExpectedConditions.elementToBeClickable(element));
	}


	/** To Wait Until Element to be Selectable */
	public static void explicitWaitElementToBeSelected(By element, int time) {
		WebDriverWait selectableWait = new WebDriverWait(driver, time);
		selectableWait.until(ExpectedConditions.elementToBeSelected(element));
	}


	/** To Wait Until Title contains the text */
	public static void explicitWaitTitleContains(By element, int time, String title) {
		WebDriverWait titleContains = new WebDriverWait(driver, time);
		titleContains.until(ExpectedConditions.titleContains(title));
	}


	/** To Wait Until Title is */
	public static void explicitWaitTitleIs(By element, int time, String title) {
		WebDriverWait titleIs = new WebDriverWait(driver, time);
		titleIs.until(ExpectedConditions.titleIs(title));
	}


	/** To Wait Until Element to be Visible */
	public static void explicitWaitVisibilityOfElement(By element, int time) {
		WebDriverWait elementToBeVisible = new WebDriverWait(driver, time);
		elementToBeVisible.until(ExpectedConditions.visibilityOfElementLocated(element));
	}


	/** To Wait Until Element is Selected */
	public static void explicitWaitSelectionStateToBe(By element, int time, boolean selected) {
		WebDriverWait elementToBeVisible = new WebDriverWait(driver, time);
		elementToBeVisible.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}

	
	/** To Wait for the Alert */
	public static void explicitWaitForAlert(int time) {
		WebDriverWait waitForAlert = new WebDriverWait(driver, time);
		waitForAlert.until(ExpectedConditions.alertIsPresent());
	}
}
