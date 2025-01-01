package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import service.CatFactService;

public class CatFactServiceTest {
    private static ExtentReports extent;

    // Setting up ExtentReports
    @BeforeSuite
    public void setupReport() {
        // Setting up the ExtentSparkReporter to write the report to an HTML file
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // Test for fetching a random cat fact
    @Test
    public void testGetRandomCatFact() {
        ExtentTest test = extent.createTest("Test Fetching Cat Fact");
        CatFactService service = new CatFactService();

        try {
            // Calling the service to get a random cat fact
            String fact = service.getRandomCatFact();
            System.out.println("Fetched Fact: " + fact);
            Assert.assertNotNull(fact, "Fact should not be null.");
            Assert.assertFalse(fact.isEmpty(), "Fact should not be empty.");

            // Logging the result in the report
            test.pass("Cat Fact fetched successfully: " + fact);
        } catch (Exception e) {
            // Logging any errors that occur during the test
            test.fail("Failed to fetch cat fact: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    // Writing the report to the HTML file after the tests are executed
    @AfterSuite
    public void tearDownReport() {
        // Writing the final report to the file
        extent.flush();
    }
}