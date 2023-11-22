package tests;
import lib.factories.ArticlePageObjectFactory;
import lib.factories.MyListsFactory;
import lib.factories.NavigationUIFactory;
import lib.factories.SearchPageObjectFactory;
import lib.test_case.CoreTestCase;
import lib.ui_common.*;

public class MyListsTests extends CoreTestCase {
    public void testSaveArticles(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        MyListsPageObject myListsPageObject = MyListsFactory.get(driver);

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
        searchPageObject.clickBackButton();

        navigationUI.clickSavedArticles();
        myListsPageObject.openSavedArticlesFolder();
        myListsPageObject.closeSyncPopup();

        myListsPageObject.swipeByArticleToDelete("Rafael Nadal");

        myListsPageObject.clickArticleDescription("Swiss tennis player (born 1981)");
        articlePageObject.waitForTitleElement();
        articlePageObject.assertTitleEquals("Roger Federer");

    }
}
