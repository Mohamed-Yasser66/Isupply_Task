package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.FileUploadPage;
import Pages.HomePage;

public class FileUploadTest extends BaseTest {
    @Test
    public void testFileUpload() {
        HomePage homePage = new HomePage(driver);
        FileUploadPage fileUploadPage = new FileUploadPage(driver);

        homePage.navigateTo("https://the-internet.herokuapp.com");
        homePage.clickFileUpload();

        fileUploadPage.uploadFile("D:\\isupply_Task\\Web GUI Test Automation\\CR7.WEBP");
        fileUploadPage.clickUploadButton();

        String uploadedFileName = fileUploadPage.getUploadedFileName();
        Assert.assertTrue(uploadedFileName.contains("CR7.WEBP"), "File upload failed!");
    }
}