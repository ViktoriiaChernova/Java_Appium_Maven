package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{
    protected static String
    MY_SAVED_TITLES_BUTTON;
    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
    public void clickSavedInMyList()
    {
        this.waitForElementAndClick(
                MY_SAVED_TITLES_BUTTON,
                "Cannot find button 'Saved'",
                60
        );
    }


}
