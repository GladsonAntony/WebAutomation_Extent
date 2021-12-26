/**
 * @Author Gladson Antony
 * @Date 10-Sep-2017
 * @timeInSeconds 11:06:48 AM
 */
package utils;

import controllers.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaiting extends BaseMethod {
    public static WebDriver driver;

    /*Select using WebElements*/

    /**
     * To Wait Until Element to be Clickable
     */
    public static void explicitWaitElementToBeClickable(WebElement element, long timeInSeconds) {
        WebDriverWait clickableWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public static void explicitWaitElementToBeSelected(WebElement element, long timeInSeconds) {
        WebDriverWait selectableWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Element has the text
     */
    public static void explicitWaitTextToBePresentInElement(WebElement element, long timeInSeconds, String text) {
        WebDriverWait textToBePresent = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        textToBePresent.until(ExpectedConditions.textToBePresentInElement(element, text));
    }


    /**
     * To Wait Until Title contains the text
     */
    public static void explicitWaitTitleContains(WebElement element, long timeInSeconds, String title) {
        WebDriverWait titleContains = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public static void explicitWaitTitleIs(WebElement element, long timeInSeconds, String title) {
        WebDriverWait titleIs = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public static void explicitWaitVisibilityOfElement(WebElement element, long timeInSeconds) {
        WebDriverWait elementToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public static void explicitWaitSelectionStateToBe(WebElement element, long timeInSeconds, boolean selected) {
        WebDriverWait elementIsSelected = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        elementIsSelected.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait Until Elements to be Visible
     */
    public static void explicitWaitVisibilityOfElements(List<WebElement> element, long timeInSeconds) {
        WebDriverWait elementsToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        elementsToBeVisible.until(ExpectedConditions.visibilityOfAllElements(element));
    }


    /*Select using By Method*/

    /**
     * To Wait Until Element to be Clickable
     */
    public static void explicitWaitElementToBeClickable(By element, long timeInSeconds) {
        WebDriverWait clickableWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public static void explicitWaitElementToBeSelected(By element, long timeInSeconds) {
        WebDriverWait selectableWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Title contains the text
     */
    public static void explicitWaitTitleContains(By element, long timeInSeconds, String title) {
        WebDriverWait titleContains = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public static void explicitWaitTitleIs(By element, long timeInSeconds, String title) {
        WebDriverWait titleIs = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public static void explicitWaitVisibilityOfElement(By element, long timeInSeconds) {
        WebDriverWait elementToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        elementToBeVisible.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public static void explicitWaitSelectionStateToBe(By element, long timeInSeconds, boolean selected) {
        WebDriverWait elementToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        elementToBeVisible.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait for the Alert
     */
    public static void explicitWaitForAlert(long timeInSeconds) {
        WebDriverWait waitForAlert = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        waitForAlert.until(ExpectedConditions.alertIsPresent());
    }
}
