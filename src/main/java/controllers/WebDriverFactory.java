/**
 * 
 */
package controllers;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * @Author Gladson Antony
 * @Date 08-Feb-2017
 */
public class WebDriverFactory extends BrowserFactory
{
	public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	public static String browser;
	public static String url;

	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		System.out.println("Browser: "+Browser);
		System.out.println("WebsiteURL: "+WebsiteURL);
		new WebDriverFactory();
		WebDriver driver = WebDriverFactory.createDriver();
		setWebDriver(driver);
		System.out.println(VideoFeature);

		if(VideoFeature.toLowerCase().contains("enabledfailed"))
		{
			setupVideoRecordingFailedOnly();
		}
		else if(VideoFeature.toLowerCase().contains("enabledall"))
		{
			setupVideoRecordingAll();
		}
	}

	public void setupVideoRecordingFailedOnly() throws Exception
	{
		VideoRecorder.conf()
		.withVideoFolder("./src/test/resources/Reports/Videos/")     					// Default is ${user.dir}/video.
		.videoEnabled(true)                       										// Disabled video globally
		.withVideoSaveMode(VideoSaveMode.FAILED_ONLY)     		// Save videos ONLY FAILED tests
		.withRecorderType(RecorderType.MONTE)    						// Monte is Default recorder
		.withRecordMode(RecordingMode.ALL)  ;								// Record video only for tests with @Video
	}

	public void setupVideoRecordingAll() throws Exception
	{
		VideoRecorder.conf()
		.withVideoFolder("./src/test/resources/Reports/Videos/")     	// Default is ${user.dir}/video.
		.videoEnabled(true)                       										// Disabled video globally
		.withVideoSaveMode(VideoSaveMode.ALL)     						// Save videos All tests
		.withRecorderType(RecorderType.MONTE)    						// Monte is Default recorder
		.withRecordMode(RecordingMode.ALL)  ;								// Record video only for tests with @Video
	}

	public void setWebDriver(WebDriver driver) 
	{
		wd.set(driver);
	}

	public static WebDriver getWebDriver() 
	{
		return wd.get();
	}

	public static void saveFullPageScreenshot(String name) throws IOException 
	{
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(getWebDriver());
		ImageIO.write(screenshot.getImage(),"PNG",new File(name));
	}


	@AfterMethod(alwaysRun=true,enabled=true)
	public void afterMethod(ITestResult result) throws Exception
	{
		Thread.sleep(2000);
		if (result.getStatus() == ITestResult.FAILURE)
		{
			saveFullPageScreenshot("./src/test/resources/Reports/Images/" + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + ".png");
		}		
		getWebDriver().quit();	
	}
}
