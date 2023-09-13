package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI
{
    static {
        MY_SAVED_TITLES_BUTTON ="id:Saved";
    }

    public iOSNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
