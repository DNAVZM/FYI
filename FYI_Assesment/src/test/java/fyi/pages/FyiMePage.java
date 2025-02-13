package fyi.pages;

import fyi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FyiMePage {
        public FyiMePage(){ PageFactory.initElements(Driver.getDriver(),this);}

        @FindBy(xpath="//p[.=' ©2024 FYI.FYI, Inc.']")
        public WebElement fyiText;

        @FindBy(xpath ="//div[@class='menu-collapse']/a")
        public WebElement menuHamburger;


        @FindBy(xpath = "//ul[contains(@class, 'u-align-left')]//li/a")
        public List<WebElement> hamburgerMenu;

        @FindBy(xpath ="//ul[contains(@class, 'u-align-left')]//li/a[text()='Help']")
        public WebElement helpOption;

        @FindBy(xpath ="//button[@aria-label='Contact Support Button']")
        public WebElement contactSupportButton;

        @FindBy(xpath ="//li[@title='Submit a request']")
        public WebElement submitRequestTitle;

        @FindBy(xpath ="//h1[@class='search-results-subheading']")
        public WebElement resultText;

        @FindBy(id ="query")
        public WebElement searchField;

}
