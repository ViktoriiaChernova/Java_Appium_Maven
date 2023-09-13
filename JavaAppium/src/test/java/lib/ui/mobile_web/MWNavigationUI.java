package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static {
        MY_SAVED_TITLES_BUTTON = "id:Saved";
    }
    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
