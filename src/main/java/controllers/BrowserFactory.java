/**
 * @Author Gladson Antony
 * @Date 26-DEC-2021
 */


package controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({listeners.ExtentTestNGIReporterListener.class,
        com.automation.remarks.testng.VideoListener.class})
public class BrowserFactory extends InitMethod {
    static WebDriver driver;

    static WebDriver createDriver() {

        switch (Browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "chrome_headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "ie":
            case "internet explorer":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "edge_headless":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser in the List");
        }

        if (ImplicitlyWait > 0) {
            implicitlyWait(ImplicitlyWait);
        }

        if (MaxPageLoadTime > 0) {
            setMaxPageLoadTime(MaxPageLoadTime);
        }

        driver.manage().window().maximize();
        driver.get(appConfig.getWebsiteUrl());
        return driver;
    }

    public static void implicitlyWait(long timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    public static void setMaxPageLoadTime(long timeInSeconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeInSeconds));
    }
}
