package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(className = "logo")
    private WebElement logoButton;

    @FindBy(className = "a4bIc")
    private WebElement searchField;

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(xpath = "//div[@class='hlcw0c']//div[@class='g']//h3")
    private List<WebElement> searchResults;

    public void assertThatAllResultsContainCorrectText(String expectedResult) {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        assertThat(searchResults.stream().map(e -> e.getText()).collect(Collectors.toList()).toString())
                .as("Search results do not contain the word selenium")
                .contains(expectedResult);
    }

    public void moveToKeyboardButton() throws InterruptedException {
        builder.moveToElement(searchField).build().perform();
        Thread.sleep(3000);
    }

    public void assertThatSearchFieldTooltipContainsCorrectText(String text) {
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]"))).size()
                .as("Expected tooltip [" + text + "] was not found.").isNotZero();
    }

    public void clickLogoButton() {
        logoButton.click();
    }
}
