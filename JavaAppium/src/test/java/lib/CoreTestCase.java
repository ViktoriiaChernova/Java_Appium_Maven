package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class CoreTestCase {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    protected RemoteWebDriver driver;

    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.openWikiWebPageForMobileWeb();
        this.skipWelcomePageForIOSApp();
        this.skipWelcomePageForAndroidApp();

    }


    @After
    @Step("Remove driver and session")
    public void tearDown()
    {
        driver.quit();
    }

   @Step("Rotate screen to portrait mode")
   protected void rotateScreenPortrait()
    {
        if (driver instanceof AppiumDriver){
          AppiumDriver driver = (AppiumDriver) this.driver;
          driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Rotate screen to landscape mode")
    protected void rotateScreenPLandscape() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenPLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Send mobile app to background (this method does nothing for mobile web")
    protected void backgroundApp(int seconds)
        {
            if (driver instanceof AppiumDriver){
                AppiumDriver driver = (AppiumDriver) this.driver;
                driver.runAppInBackground(Duration.ofSeconds(seconds));
            } else {
                System.out.println("Method backgroundApp() does nothing for platform " + Platform.getInstance().getPlatformVar());
            }
        }

    @Step("Open Wiki URL for mobile web (this method does nothing for Android and iOS")
    protected void openWikiWebPageForMobileWeb()
        {
            if(Platform.getInstance().isMW()) {
                driver.get("https://en.m.wikipedia.org");
            } else {
                System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform " + Platform.getInstance().getPlatformVar());
            }
        }

    @Step("Skip welcome page screen for iOS")
    private void skipWelcomePageForIOSApp() {
        if (Platform.getInstance().isiOS()) {
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkipIOS();
        }
    }

    private void skipWelcomePageForAndroidApp() {
        if (Platform.getInstance().isAndroid()) {
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkipAndroid();
        }
    }
}

