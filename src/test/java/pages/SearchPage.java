package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='FPdoLc.tfB0Bf']//input[@name='btnK']")
    private WebElement searchButton;

    public void assertThatSearchResultsFieldIsEmpty() {
        assertThat(searchField.getText()).as("Search Result field is not empty").contains("");
    }

    public void fillInSearchField(String text) {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.xpath("//div[@class='FPdoLc.tfB0Bf']//input[@name='btnK']"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
        } else {
            pressEnter();
        }
    }
}
