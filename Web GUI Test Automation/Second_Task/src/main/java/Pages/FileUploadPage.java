package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {
    private WebDriver driver;
    private By chooseFileInput = By.id("file-upload");
    private By uploadButton = By.className("button");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String filePath) {
        WebElement fileInput = driver.findElement(chooseFileInput);
        fileInput.sendKeys(filePath);
    }

    public void clickUploadButton() {
        WebElement button = driver.findElement(uploadButton);
        button.click();
    }

    public String getUploadedFileName() {
        return driver.findElement(uploadedFiles).getText();
    }
}