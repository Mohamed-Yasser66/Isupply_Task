package tests;

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
import Pages.HomePage;
import Pages.SearchResultsPage;

public class GoogleSearchTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        // Set up ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Test Execution Report");
        sparkReporter.config().setReportName("Google Search Test Report");

        // Initialize ExtentReports and attach the SparkReporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set up WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void testSearchSeleniumWebDriver() {
        test = extent.createTest("Test Search Selenium WebDriver", "Verify search functionality on Google");

        try {
            // Step 1: Navigate to Google
            test.info("Navigating to Google");
            homePage.navigateToGoogle();

            // Step 2: Search for "selenium webdriver"
            test.info("Searching for 'selenium webdriver'");
            homePage.search("selenium webdriver");

            // Step 3: Validate the third result text
            test.info("Validating the third result text");
            String thirdResultText = searchResultsPage.getResultText(3);
            Assert.assertTrue(thirdResultText.toLowerCase().contains("what is selenium webdriver"),
                    "The third result does not contain the expected text.");
            test.pass("Test passed successfully");

        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.quit();
        }
        // Write the report
        extent.flush();
    }
}