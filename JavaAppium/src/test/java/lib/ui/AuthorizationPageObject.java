package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
    private static final String
            LOGIN_BUTTON = "xpath://body/div/div/a[span='Log in']",
            LOGIN_INPUT = "css:input[name='wpName']", // если есть input id и name
            PASSWORD_INPUT = "css:input[name='wpPassword']",
            SUBMIT_BUTTON = "css:button#wpLoginAttempt"; // если у button class есть id

    public AuthorizationPageObject(RemoteWebDriver driver) {

        super(driver);
    }

    public void clickAuthButton() {
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button", 20);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click auth button", 30);
    }

    public void enterLoginData(String login, String password) {
        this.waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find and put a login to the login input", 10);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password, "Cannot find and put a password to the password input", 10);
    }

    public void submitForm() {
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button", 10);
        String url = driver.getCurrentUrl();
        String new_url = url.substring(0,11) + "m." + url.substring(11);
        driver.get(new_url);
    }
}
