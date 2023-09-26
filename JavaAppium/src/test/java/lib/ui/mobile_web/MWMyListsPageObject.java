package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class, 'content-unstyled')]//h3[contains(text(),'{TITLE}')]";
        //CLOSE_BUTTON_LOG_IN_WINDOW = "xpath://XCUIElementTypeButton[@name='Close']";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class, 'content-unstyled')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watched')]";
    }
    public MWMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
