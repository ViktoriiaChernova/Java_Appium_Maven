package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static {
        MY_SAVED_TITLES_BUTTON = "css:a[data-event-name='menu.watchlist']";
        OPEN_NAVIGATION = "css:[id='mw-mf-main-menu-button']";
    }
    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
