package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;

public class SearchTests extends CoreTestCase {
    public void testClearResult(){
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.waitSearchResultList();

        searchPageObject.clearSearch();
        searchPageObject.waitCloseButtonIsNotPresent();
    }

    public void testSearchResultsAreRelevant(){
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchElement();

        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitSearchResultList();

        searchPageObject.assertSearchResultHasText("Java", 1);

        searchPageObject.assertSearchResultHasText("Java", 2);
        searchPageObject.assertSearchResultHasText("Java", 3);
        searchPageObject.assertSearchResultHasText("Java", 4);
        searchPageObject.assertSearchResultHasText("Java", 5);
        searchPageObject.assertSearchResultHasText("Java", 6);

    }
}
