package com.klymchuk.rozetkaProject.pages;

import com.klymchuk.rozetkaProject.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by iklymchuk on 4/12/17.
 */
public class ProfilePage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = ".//*[text()[contains(.,'Электронная почтa')]]/../div[@class='profile-f-i-field']") //looks really horrible
    private WebElement profileEmail;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProfileEmail() {
        return profileEmail.getText();
    }

}
