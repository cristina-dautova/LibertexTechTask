package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchPage.fillInSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultSteps();
    }

    public SearchSteps verifyThatSearchResultsFieldIsEmpty() {
        searchPage.assertThatSearchResultsFieldIsEmpty();
        return this;
    }
}
