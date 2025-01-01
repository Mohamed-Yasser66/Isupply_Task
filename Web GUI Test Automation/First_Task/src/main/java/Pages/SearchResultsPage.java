package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(css = "div#rso div.g")
    private List<WebElement> searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getResultText(int index) {
        if (index <= searchResults.size()) {
            return searchResults.get(index - 1).getText();
        }
        return null;
    }
}