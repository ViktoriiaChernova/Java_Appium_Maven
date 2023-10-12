package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class SearchTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value ="Search")})
    @DisplayName("Search article")
    @Description("Searching article")
    @Step("Starting test testSearch")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearch()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");

    }

    @Test
    @Features(value = {@Feature(value ="Search")})
    @DisplayName("Cancel searching")
    @Description("Canceling searching")
    @Step("Starting test testCancelSearch")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }

    @Test
    @Features(value = {@Feature(value ="Search")})
    @DisplayName("Check amount of search results")
    @Description("Checking search results are not empty")
    @Step("Starting test testAmountOfNotEmptySearch")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        );

    }

    @Test
    @Features(value = {@Feature(value ="Search")})
    @DisplayName("Check no results page")
    @Description("Checking page contains no results of search")
    @Step("Starting test testAmountOfEmptySearch")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "fdhjfhfhhffh";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    @Features(value = {@Feature(value ="Search")})
    @DisplayName("Check search input")
    @Description("Checking search input contains placeholder")
    @Step("Starting test testElementContainsText")
    @Severity(value = SeverityLevel.MINOR)
    public void testElementContainsText()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String expected_text = "Search Wikipedia";
        SearchPageObject.assertElementContainsText(expected_text);
    }

    @Test
    @Features(value = {@Feature(value ="Search")})
    @DisplayName("Search title and cancel search")
    @Description("Searching title, checking search results and canceling search")
    @Step("Starting test testSearchTitleAndCancelSearch")
    @Severity(value = SeverityLevel.NORMAL)
    public void testSearchTitleAndCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "apple";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult("Fruit that grows on a tree");
        SearchPageObject.waitForSearchResult("American multinational technology corporation");
        SearchPageObject.clickClearQuery();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    @Features(value = {@Feature(value ="Search"),@Feature(value ="Article"),@Feature(value ="My list")})
    @DisplayName("Check searching title contains word")
    @Description("Checking searching title contains expected word")
    @Step("Starting test testSearchTitleContainsWord")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearchTitleContainsWord()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "apple";
        SearchPageObject.typeSearchLine(search_line);
        String expected_word = "Apple";
        SearchPageObject.titleContainsWord(expected_word);
    }
}
