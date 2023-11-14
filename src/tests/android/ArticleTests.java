package tests.android;
import lib.test_case.AndroidTestCase;
import lib.ui_android.ArticlePageObject;
import lib.ui_android.SearchPageObject;

public class ArticleTests extends AndroidTestCase {
    public void testArticleTitle(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchElement();

        searchPageObject.typeSearchLine("Nadal");
        searchPageObject.clickArticleName("Rafael Nadal");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.assertTitleEquals("Rafael Nadal");

    }
}
