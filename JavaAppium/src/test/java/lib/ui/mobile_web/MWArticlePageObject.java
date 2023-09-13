package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    private static String name_of_folder = "Learning programming";
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        SAVE_BUTTON = "xpath://a[span='Watch']"; //локатор через id
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://a[span='Unwatch']";
        //CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
       // CLOSE_ARTICLE_BUTTON ="xpath://XCUIElementTypeButton[@name='Search']";
    }

    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}

