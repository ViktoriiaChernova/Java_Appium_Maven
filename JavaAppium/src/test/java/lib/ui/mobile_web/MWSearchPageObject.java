package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULTS_ELEMENT = "css:p.without-results";
       // SEARCH_ELEMENT_CONTAINS_TEXT = "xpath://XCUIElementTypeStaticText[@name='Appium']";
        //SEARCH_CLEAR_QUERY = "xpath://XCUIElementTypeButton[@name='Clear text']";
    }
    public MWSearchPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
