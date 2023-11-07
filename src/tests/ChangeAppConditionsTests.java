package tests;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;

public class ChangeAppConditionsTests extends CoreTestCase {
    public void testRotationTest(){
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.clickArticleName("Java (programming language)");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);

        String title_before = articlePageObject.getTitleText();
        articlePageObject.assertTitleEquals("Java (programming language)");
        rotateLandscape();

        String title_after = articlePageObject.getTitleText();

        assertEquals("Titles before and after rotation are not the same", title_after, title_before);
        rotatePortrate();

    }
}
