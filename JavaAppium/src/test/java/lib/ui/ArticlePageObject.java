package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends  MainPageObject
{
    private static String name_of_folder = "Learning programming";
    protected static String
    TITLE,
    FOOTER_ELEMENT,
    SAVE_BUTTON,
    CANCEL_BUTTON,
    PAGE_SAVE_BUTTON,
    NAME_OF_FOLDER,
    SAVE_ADD_TO_MY_LIST_BUTTON,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON,
    SNACKBAR_VIEW_LIST_BUTTON,
    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("Waiting for title on the article page")
    public WebElement waitForTitleElement()
    {
       return  this.waitForElementPresent(TITLE, "Cannot find article title on page", 40 );
    }

    @Step("Get article title")
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isiOS()) {
            return  title_element.getAttribute("name");
        } else {
            return  title_element.getText();
        }
    }

    @Step("Swiping to footer on article page")
    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else if (Platform.getInstance().isiOS()) {
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                     40);
        } else {
            this.scrollWebPageTitleElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        }
    }

    @Step("Adding the article to my list")
    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find button 'Save'",
                5
        );

        this.waitForElementAndClick(
                SAVE_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button 'ADD TO LIST'",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot find button 'OK'",
                5
        );
    }

    @Step("Adding the article to existing list")
    public void addArticleToExistingList(String name_of_folder) {

        this.waitForElementPresent(
                PAGE_SAVE_BUTTON,
                "Cannot find button 'Save'",
                10
        );
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find button 'Save'",
                5
        );

        this.waitForElementAndClick(
                SAVE_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button 'ADD TO LIST'",
                5
        );

        this.waitForElementAndClick(
                NAME_OF_FOLDER,
                "Cannot find saved list",
                5
        );

        this.waitForElementAndClick(
                SNACKBAR_VIEW_LIST_BUTTON,
                "Cannot find saved list",
                5
        );
    }

    @Step("Closing article")
    public void closeArticle()
    {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot click back button",
                    5);
        } else if (Platform.getInstance().isiOS()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot click back button",
                    5);
            this.waitForElementAndClick(
                    CANCEL_BUTTON,
                    "Cannot close article, cannot click CANCEL button",
                    10);
        } else {
            System.out.println("Method closeArticle() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Adding the article to my saved")
    public void addArticlesToMySaved()
    {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(SAVE_BUTTON, "Cannot find SAVE button", 20);
    }

    @Step("Removing the article from saved if it has been added")
    public void removeArticleFromSavedIfItAdded ()
    {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    1
            );
            this.waitForElementPresent(
                    SAVE_BUTTON,
                    "Cannot find save button",
                    10
            );
        }
    }
}
