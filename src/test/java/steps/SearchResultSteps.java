package steps;

import pages.SearchResultsPage;

public class SearchResultSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultSteps verifyThatAllResultsContainCorrectText(String text) {
        searchResultsPage.assertThatAllResultsContainCorrectText(text);
        return this;
    }

    public SearchResultSteps openTooltip() throws InterruptedException {
        searchResultsPage.moveToKeyboardButton();
        return this;
    }

    public SearchResultSteps verifyThatKeyboardTooltipContainsProperText(String text) {
        searchResultsPage.assertThatSearchFieldTooltipContainsCorrectText(text);
        return this;
    }

    public SearchSteps clickLogo() {
        searchResultsPage.clickLogoButton();
        return new SearchSteps();
    }
}
