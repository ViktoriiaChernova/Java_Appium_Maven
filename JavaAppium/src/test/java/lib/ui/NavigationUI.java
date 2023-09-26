package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{
    protected static String
    MY_SAVED_TITLES_BUTTON,
    OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation()
    {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 10);
        } else {
            System.out.println("Method openNavigation() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
    public void clickSavedInMyList()
    {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    MY_SAVED_TITLES_BUTTON,
                    "Cannot find button 'Saved'",
                    5
            );
        }
        this.waitForElementAndClick(
                MY_SAVED_TITLES_BUTTON,
                "Cannot find button 'Saved'",
                60
        );
    }


}
