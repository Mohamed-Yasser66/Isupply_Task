package tests;

import Pages.DynamicLoadingPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicLoadingTest {
    WebDriver driver;
    DynamicLoadingPage dynamicLoadingPage;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setUp() {
        // إعداد تقرير ExtentReports
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReport.html");
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Dynamic Loading Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Your Name");
        extent.setSystemInfo("Environment", "QA");

        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Test
    public void testDynamicLoading() {
        // إنشاء اختبار في التقرير
        test = extent.createTest("Dynamic Loading Test", "Verify 'Hello World!' text appears correctly.");

        try {
            // Navigate to "Dynamic Loading"
            test.info("Navigating to Dynamic Loading page.");
            dynamicLoadingPage.navigateToDynamicLoading();

            // Click on "Example 2"
            test.info("Clicking on Example 2 link.");
            dynamicLoadingPage.clickExample2();

            // Click "Start" and verify the displayed text
            test.info("Clicking Start button and waiting for text to appear.");
            dynamicLoadingPage.clickStart();
            String displayedText = dynamicLoadingPage.getHelloWorldText();

            // Assertion
            Assert.assertEquals(displayedText, "Hello World!", "Text did not match expected value.");
            test.pass("Test passed: 'Hello World!' text is displayed correctly.");
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        // كتابة التقرير إلى الملف
        extent.flush();
    }
}