package tests;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;

public class ArticleTests extends CoreTestCase {
    public void testArticleTitle(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchElement();

        searchPageObject.typeSearchLine("Nadal");
        searchPageObject.clickArticleName("Rafael Nadal");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.assertTitleEquals("Rafael Nadal");

    }
}
