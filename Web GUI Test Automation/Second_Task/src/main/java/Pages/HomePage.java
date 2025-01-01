package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By fileUploadLink = By.linkText("File Upload");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickFileUpload() {
        WebElement link = driver.findElement(fileUploadLink);
        link.click();
    }
}