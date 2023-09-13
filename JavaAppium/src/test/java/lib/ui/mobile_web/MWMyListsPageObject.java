package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://*[@name='{TITLE}']";
        CLOSE_BUTTON_LOG_IN_WINDOW = "xpath://XCUIElementTypeButton[@name='Close']";
    }
    public MWMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
