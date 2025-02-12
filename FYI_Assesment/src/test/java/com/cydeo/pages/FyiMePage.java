package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FyiMePage {

    public FyiMePage(){ PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//p[.=' ©2024 FYI.FYI, Inc.']")
    public WebElement fyiText;

    @FindBy(css ="#sec-5a81 > div > nav > div.menu-collapse > a > svg.u-svg-link")
    public WebElement menuHamburger;

    @FindBy(xpath = "//ul[contains(@class, 'u-align-left')]//li")
    public List<WebElement> hamburgerMenu;

}
