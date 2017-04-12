package com.klymchuk.rozetkaProject.pages;

import com.klymchuk.rozetkaProject.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by iklymchuk on 4/12/17.
 */
public class IphonePage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = ".//*[text()[contains(.,'Вес')]]/../dd")
    private WebElement weigth;

    @FindBy(xpath = ".//span[text()[contains(.,'Диагональ экрана')]]/../../dd")
    private WebElement diagonal;

    @FindBy(xpath = ".//*[text()[contains(.,'Оперативная память')]]/../../dd")
    private WebElement ram;

    @FindBy(xpath = ".//*[@itemprop='price']")
    private WebElement price;

    @FindBy(xpath = ".//*[@name='topurchases']")
    private WebElement buy;

    @FindBy(xpath = ".//*[@class='popup-close']")
    private WebElement closePopup;

    @FindBy(xpath = ".//*[@class='hub-i-count']")
    private WebElement countOfPurchase;

    public IphonePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getWeight() {
        return weigth.getText();
    }

    public String getDiagonal() {
        return diagonal.getText();
    }

    public String getRam() {
        return ram.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getCountOfPurchase() {
        return countOfPurchase.getText();
    }

    public void buy() throws InterruptedException {
        buy.click();
        Thread.sleep(5000); //bad solution
        closePopup.click();
        Thread.sleep(5000); //bad solution
    }

}
