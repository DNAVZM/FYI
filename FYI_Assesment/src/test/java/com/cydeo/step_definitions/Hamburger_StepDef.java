package com.cydeo.step_definitions;

import com.cydeo.pages.FyiMePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Hamburger_StepDef {

    private BrowserUtils browserUtils = new BrowserUtils();
    FyiMePage fyiMePage = new FyiMePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

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
        List<String> actualMenuOptions = fyiMePage.hamburgerMenu.stream()
                .map(WebElement::getText) // Get text from each WebElement
                .collect(Collectors.toList());

        // Print both lists for debugging purposes
        System.out.println("Expected Menu Options: " + expectedMenuOptions);
        System.out.println("Actual Menu Options: " + actualMenuOptions);

        // Assert that the two lists are equal
        BrowserUtils.assertListsEqual(expectedMenuOptions, actualMenuOptions, "The actual menu options do not match the expected options.");
//        Assertions.assertEquals(expectedMenuOptions, actualMenuOptions,
//                "The actual menu options do not match the expected options.");
    }

}
