/**
 * @Author Gladson Antony
 * @Date 10-Sep-2017
 * @Time 10:30:43 AM
 */
package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import controllers.InitMethod;
import org.testng.*;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentTestNGIReporterListener extends InitMethod implements IReporter {
    @SuppressWarnings("rawtypes")
    public void generateReport(List xmlSuites, List suites, String outputDirectory) {
        init();
        for (Object suite : suites) {
            Map result = ((ISuite) suite).getResults();

            for (Object res : result.values()) {
                ITestContext context = ((ISuiteResult) res).getTestContext();

                try {
                    buildTestNodes(context.getFailedTests(), Status.FAIL);
                    buildTestNodes(context.getSkippedTests(), Status.SKIP);
                    buildTestNodes(context.getPassedTests(), Status.PASS);
                } catch (Exception e) {
                }
            }
        }
        for (String s : Reporter.getOutput()) {
            extent.addTestRunnerOutput(s);
        }
        extent.setSystemInfo("Author", "Gladson Antony");
        extent.setSystemInfo("Browser", Browser);
        extent.setSystemInfo("OS", OSName);
        extent.setSystemInfo("OS Version", OSVersion);
        extent.setSystemInfo("OS Architecture", OSArchitecture);
        extent.setSystemInfo("OS Bit", OSBit);
        extent.setSystemInfo("JAVA Version", System.getProperty("java.version"));
        try {
            extent.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
            extent.setSystemInfo("Host IP Address", InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e) {
        }
        extent.flush();
    }

    private void init() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        sparkReporter.config().setDocumentTitle("Extent Report_Gladson Antony");
        sparkReporter.config().setReportName("Extent Report_Gladson Antony");
        sparkReporter.config().setTimeStampFormat("HH:mm:ss");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setProtocol(Protocol.HTTPS);
        sparkReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    private void buildTestNodes(IResultMap tests, Status status) throws Exception {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable().getMessage());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                if (result.getStatus() == ITestResult.FAILURE) {
                    test.fail(result.getTestClass().getName()
                                    + "." + result.getMethod().getMethodName(),
                            MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")
                                    + "/src/test/resources/Reports/Images/" + result.getTestClass().getName()
                                    + "." + result.getMethod().getMethodName() + ".png").build());

                    test.addScreenCaptureFromPath(System.getProperty("user.dir")
                            + "./src/test/resources/Reports/Images/"
                            + result.getTestClass().getName()
                            + "." + result.getMethod().getMethodName() + ".png");

                }
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}