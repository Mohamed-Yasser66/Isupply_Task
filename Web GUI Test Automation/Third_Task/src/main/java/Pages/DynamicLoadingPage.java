package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicLoadingPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By dynamicLoadingLink = By.linkText("Dynamic Loading");
    By example2Link = By.partialLinkText("Example 2");
    By startButton = By.tagName("button");
    By helloWorldText = By.id("finish");

    // Constructor
    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods
    public void navigateToDynamicLoading() {
        driver.findElement(dynamicLoadingLink).click();
    }

    public void clickExample2() {
        driver.findElement(example2Link).click();
    }

    public void clickStart() {
        driver.findElement(startButton).click();
    }

    public String getHelloWorldText() {
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(helloWorldText));
        return textElement.getText();
    }
}