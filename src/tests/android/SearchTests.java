package tests.android;

import lib.test_case.AndroidTestCase;
import lib.ui_android.SearchPageObject;

public class SearchTests extends AndroidTestCase {
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

    public void testSearchArticleWithTitleAndDescription(){
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.waitForElementByTitleAndDescription("Java", "Island in Indonesia");
        searchPageObject.waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
        searchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");

    }
}
