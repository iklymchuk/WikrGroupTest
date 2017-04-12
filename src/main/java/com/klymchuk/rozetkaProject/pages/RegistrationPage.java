package com.klymchuk.rozetkaProject.pages;

import com.klymchuk.rozetkaProject.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by iklymchuk on 4/12/17.
 */
public class RegistrationPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = ".//*[@data-title='Ваше имя']")
    private WebElement username;


    @FindBy(xpath = ".//*[@data-title='Электронная почта']")
    private WebElement email;

    @FindBy(xpath = ".//*[@data-title='Придумайте пароль']")
    private WebElement password;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProfilePage registered(String user, String pass, String mail) {
        username.sendKeys(user);
        email.sendKeys(mail);
        password.sendKeys(pass);
        password.submit();

        return new ProfilePage(driver);
    }
}
