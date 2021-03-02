package tests;

import org.testng.annotations.Test;

public class GoogleComTest extends BaseTest {

    @Test(dataProvider = "dataProvider", priority = 1)
    public void verifySearchResultsTest(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .verifyThatAllResultsContainCorrectText("selenium");
    }

    @Test(dataProvider = "dataProvider", priority = 2)
    public void verifyOpenKeyboardTooltipOnGoogleTest(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .openTooltip()
                .verifyThatKeyboardTooltipContainsProperText("Поиск");
    }

    @Test(dataProvider = "dataProvider", priority = 3)
    public void verifySearchResultsFieldIsEmptyAfterPressingLogoTest(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .clickLogo()
                .verifyThatSearchResultsFieldIsEmpty();
    }
}
