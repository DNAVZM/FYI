package fyi.step_definitions;

import fyi.pages.FyiMePage;
import fyi.utilities.BrowserUtils;
import fyi.utilities.ConfigurationReader;
import fyi.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FyiMe_StepDefinitions {


    private WebDriver driver;
    private BrowserUtils browserUtils = new BrowserUtils();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    FyiMePage fyiMePage = new FyiMePage();

    @Given("I navigate to the FYI Terms of Service page")
    public void navigateToTermsOfServicePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fyi"));
    }

//        @Then("the copyright text should be {string} at the bottom of the page")
//        public void verifyCopyrightText() {
//            WebElement copyrightElement = fyiMePage.fyiText;
//
//            String expectedCopyright = " ©2024 FYI.FYI, Inc.";
//            String actualCopyright = copyrightElement.getText();
//
////            assert actualCopyright.contains(" ©2024 FYI.FYI, Inc.");
//
//            assertEquals("Copyright text is incorrect", expectedCopyright, actualCopyright);
//
//            driver.quit(); // Close the browser
//        }

    @When("I navigate to help")
    public void INavigateToHelp() {
        wait.until(ExpectedConditions.visibilityOf(fyiMePage.helpOption));
        fyiMePage.helpOption.click();
        BrowserUtils.switchToNextWindow();
    }

    @When("I click on contact support")
    public void IClickOnContactSupport() {
        wait.until(ExpectedConditions.visibilityOf(fyiMePage.contactSupportButton));
        fyiMePage.contactSupportButton.click();
    }

    @When("I enter {string} into search field")
    public void IEnterTextInSearch(String inputText) {
        wait.until(ExpectedConditions.visibilityOf(fyiMePage.searchField));
        fyiMePage.searchField.sendKeys(inputText + Keys.ENTER);
    }

    @When("I verify {int} results for {string} search")
    public void IVerifyNumberOfResults(int expectedResultNumber, String expectedSearchTerm) {
        wait.until(ExpectedConditions.visibilityOf(fyiMePage.resultText));
        String expected = expectedResultNumber + " results for \"" + expectedSearchTerm + "\"";
        String actual = fyiMePage.resultText.getText().trim();
        Assert.assertEquals(expected, actual);
    }

    @Then("we verify page is redirected to the Submit Request page")
    public void verifyWeAreOnSubmitRequest() {
        wait.until(ExpectedConditions.visibilityOf(fyiMePage.submitRequestTitle));
        String expected = "Submit a request";
        String actual = fyiMePage.submitRequestTitle.getText().trim();
        BrowserUtils.switchToNextWindow();
        Assert.assertEquals(expected, actual);

    }


    @Then("the copyright text should be at the bottom of the page")
    public void the_copyright_text_should_be_at_the_bottom_of_the_page() {
        WebElement copyrightElement = fyiMePage.fyiText;

        String expectedCopyright = "©2024 FYI.FYI, Inc.";
        String actualCopyright = copyrightElement.getText().trim();

        System.out.println(actualCopyright + "______________________________");
//            assert actualCopyright.contains(" ©2024 FYI.FYI, Inc.");
//        assertEquals("Copyright text is incorrect", expectedCopyright, actualCopyright);
//        assertEquals("Copyright text is incorrect", expectedCopyright, actualCopyright);
        browserUtils.contains(actualCopyright, expectedCopyright);


//        driver.quit(); // Close the browser
    }

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fyi"));
    }

    @When("the user clicks on the hamburger menu icon")
    public void the_user_clicks_on_the_hamburger_menu_icon() {
        fyiMePage.menuHamburger.click();
    }

    //    @Then("the menu should contain the following options:")
//    public void the_menu_should_contain_the_following_options(io.cucumber.datatable.DataTable dataTable) {
//        if (fyiMePage.hamburgerMenu.size() == 7) {
//            System.out.println("The list contains 7 elements. Proceeding...");
//            for (WebElement element : fyiMePage.hamburgerMenu) {
//                System.out.println(element.getText());
//            }
//
//
//        } else {
//            System.out.println("The list does not contain exactly 7 elements. Found: " + fyiMePage.hamburgerMenu.size());
//        }
//
//
//    }
    @Then("the menu should contain the following options:")
    public void the_menu_should_contain_the_following_options(io.cucumber.datatable.DataTable dataTable) {
        // Convert DataTable to a List of Strings (expected menu options)
        List<String> expectedMenuOptions = dataTable.asList();

        // Extract actual menu options from fyiMePage.hamburgerMenu
        wait.until(ExpectedConditions.visibilityOfAllElements(fyiMePage.hamburgerMenu));
        List<String> actualMenuOptions = fyiMePage.hamburgerMenu.stream()
                .map(WebElement::getText) // Get text from each WebElement
                .collect(Collectors.toList());

        // Print both lists for debugging purposes
        System.out.println("Expected Menu Options: " + expectedMenuOptions);
        System.out.println("Actual Menu Options:   " + actualMenuOptions);

        // Assert that the two lists are equal
        BrowserUtils.assertListsEqual(expectedMenuOptions, actualMenuOptions, "The actual menu options do not match the expected options.");
//        Assertions.assertEquals(expectedMenuOptions, actualMenuOptions,
//                "The actual menu options do not match the expected options.");
    }

}


