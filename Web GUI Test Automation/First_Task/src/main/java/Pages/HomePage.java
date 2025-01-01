package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(id = "APjFqb")
    private WebElement searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToGoogle() {
        driver.get("http://www.google.com/ncr");
    }

    public void search(String query) {
        waitForElement(searchBox, 10).sendKeys(query);
        searchBox.submit();
    }
}