package tests.android;
import lib.test_case.AndroidTestCase;
import lib.ui_android.ArticlePageObject;
import lib.ui_android.MyListsPageObject;
import lib.ui_android.NavigationUI;
import lib.ui_android.SearchPageObject;

public class MyListsTests extends AndroidTestCase {
    public void testSaveArticles(){
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        NavigationUI navigationUI = new NavigationUI(driver);
        MyListsPageObject myListsPageObject = new MyListsPageObject(driver);

        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Roger Federer");

        searchPageObject.clickArticleName("Roger Federer");

        articlePageObject.saveArticle();

        articlePageObject.clickBackButton();
        searchPageObject.clearSearch();

        searchPageObject.typeSearchLine("Nadal");
        searchPageObject.clickArticleName("Rafael Nadal");

        articlePageObject.saveArticle();

        articlePageObject.clickBackButton();
        articlePageObject.clickBackButton();

        navigationUI.clickSavedArticles();

        myListsPageObject.openSavedArticlesFolder();

        myListsPageObject.swipeByArticleToDelete("Rafael Nadal");

        myListsPageObject.clickArticleDescription("Swiss tennis player (born 1981)");
        articlePageObject.waitForTitleElement();
        articlePageObject.assertTitleEquals("Roger Federer");

    }
}
