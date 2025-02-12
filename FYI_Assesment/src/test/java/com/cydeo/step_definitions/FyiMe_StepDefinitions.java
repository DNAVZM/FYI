package com.cydeo.step_definitions;

import com.cydeo.pages.FyiMePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FyiMe_StepDefinitions {

        private WebDriver driver;
    private BrowserUtils browserUtils = new BrowserUtils();

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

    @Then("the copyright text should be at the bottom of the page")
    public void the_copyright_text_should_be_at_the_bottom_of_the_page() {
        WebElement copyrightElement = fyiMePage.fyiText;

        String expectedCopyright = "©2024 FYI.FYI, Inc.";
        String actualCopyright = copyrightElement.getText().trim();

        System.out.println(actualCopyright+"______________________________");
//            assert actualCopyright.contains(" ©2024 FYI.FYI, Inc.");
//        assertEquals("Copyright text is incorrect", expectedCopyright, actualCopyright);
//        assertEquals("Copyright text is incorrect", expectedCopyright, actualCopyright);
        browserUtils.contains(actualCopyright,expectedCopyright);



//        driver.quit(); // Close the browser
    }
    }
